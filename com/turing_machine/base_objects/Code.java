package com.turing_machine.base_objects;

public class Code {

	private CodeValue[] values;

	public Code(CodeValue first_value, CodeValue second_value, CodeValue third_value) {

	}

	@Override
	public String toString()
	{
		try {
			return ""+this.values[0].toInteger()+this.values[1].toInteger()+this.values[2].toInteger();
		} catch (Exception e) {
			return "???"; // this case should not be attained
		}
	}

	public CodeValue getValue(CodeIndex index) {
		return null;
	}

	public boolean equals(Code other_code) {
		return false;
	}

	public int count(CodeValue value)
	{
		int count = 0;

		for (int i=1; i <= 3; ++i)
		{
			CodeValue value_at_index = getValue(CodeIndex.fromValue(i));

			if (value_at_index == value) ++count;
		}

		return count;
	}

	public int sum()
	{
		return 0;
	}

}
