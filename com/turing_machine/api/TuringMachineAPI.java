package com.turing_machine.api;

import com.turing_machine.base_objects.Code;
import com.turing_machine.base_objects.CodeValue;
import com.turing_machine.base_objects.CriterionLetter;
import com.turing_machine.base_objects.GameCriteriaCount;
import com.turing_machine.base_objects.GameDifficulty;
import com.turing_machine.exceptions.TuringMachineAPIException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.NoSuchObjectException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class TuringMachineAPI {

	private final String endpoint_url;

	public TuringMachineAPI(String endpoint_url) {
		this.endpoint_url = endpoint_url;
	}

	public TuringMachineGeneratedConfiguration generateGameConfiguration(GameDifficulty difficulty, GameCriteriaCount criteria_count) throws TuringMachineAPIException {
		String data_content = callAPIConfiguration(difficulty, criteria_count);

		try {
			JSONObject object = new JSONObject(data_content);

			String status = object.getString("status");
			if (!status.equals("ok"))
			{
				throw new TuringMachineAPIException("distant API returned a non-ok result");
			}

			String given_code = "" + object.getInt("code");
			GameDifficulty given_difficulty = integerToDifficulty(object.getInt("difficulty"));
			GameCriteriaCount given_criteria_count = GameCriteriaCount.fromInteger(Integer.parseInt(object.getString("n")));

			JSONArray given_criteria = object.getJSONArray("ind");
			JSONArray given_cases = object.getJSONArray("law");

			ArrayList<TuringMachineGeneratedCriterion> criteria = new ArrayList<>();
			for (int i=0; i < given_criteria_count.toInteger(); ++i)
			{
				criteria.add(
					new TuringMachineGeneratedCriterion(given_criteria.getInt(i), CriterionLetter.fromInteger(i), given_cases.getInt(i))
				);
			}
			
			Code code = new Code(
				CodeValue.fromInteger(Character.getNumericValue(given_code.charAt(0))),
				CodeValue.fromInteger(Character.getNumericValue(given_code.charAt(1))),
				CodeValue.fromInteger(Character.getNumericValue(given_code.charAt(2)))
			);

			return new TuringMachineGeneratedConfiguration(
				code,
				given_difficulty,
				given_criteria_count,
				criteria
			);

		} catch (Exception e) {
			throw new TuringMachineAPIException("bad answer format from API (" + e.getMessage() + ")");
		}
	}
	
	public String callAPIConfiguration(GameDifficulty difficulty, GameCriteriaCount criteria_count) throws TuringMachineAPIException
	{
		URL url;

		try {
			url = new URL("https://" + endpoint_url + "/api.php?uuid=&m=0&d"+difficultyToInteger(difficulty)+"&n="+criteria_count.toInteger());
		} catch (MalformedURLException e) {
			System.err.println("Warning : URL not recognized");
			throw new TuringMachineAPIException("bad URL");
		}
		
		HttpURLConnection con = null;
		try {
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Referer", "https://" + endpoint_url + "/");
			con.setRequestProperty("Host", endpoint_url);

			int status = con.getResponseCode();
			if (status != 200)
			{
				throw new TuringMachineAPIException("generation refused with code " + status);
			}

			BufferedReader in;
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));

			String inputLine;
			StringBuffer content = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();

			return content.toString();
		} catch (IOException ex) {
			if (con != null) con.disconnect();
			throw new TuringMachineAPIException("an error occured while reading the answer");
		}
	}

	public static int difficultyToInteger(GameDifficulty difficulty)
	{
		switch (difficulty) {
			case GameDifficulty.EASY:
				return 0;
			case GameDifficulty.STANDARD:
				return 1;
			case GameDifficulty.HARD:
				return 2;
		}

		return -1;
	}

	public static GameDifficulty integerToDifficulty(int difficulty) throws NoSuchObjectException
	{
		switch (difficulty) {
			case 0:
				return GameDifficulty.EASY;
			case 1:
				return GameDifficulty.STANDARD;
			case 2:
				return GameDifficulty.HARD;
		}

		throw new NoSuchObjectException(difficulty + " is not a valid game difficulty");
	}

}
