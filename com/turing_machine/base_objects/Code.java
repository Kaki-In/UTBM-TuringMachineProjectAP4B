package com.turing_machine.base_objects;

public class Code {

	private CodeValue[] values;

	public Code(CodeValue first_value, CodeValue second_value, CodeValue third_value) {

		this.values = new CodeValue[] {first_value, second_value, third_value};
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
		return this.values[index.toInteger() - 1];
	}

	public boolean equals(Code other_code) {
	
		for (int i = 0; i < this.values.length; i++) {
			if (this.values[i] != other_code.values[i]) {
				return false; 
			}
		}
	
		return true; 
	}

	public int count(CodeValue value)
	{
		int count = 0;

		for (int i=1; i <= 3; ++i)
		{
			CodeValue value_at_index = getValue(CodeIndex.fromInteger(i));

			if (value_at_index == value) ++count;
		}

		return count;
	}

	public int sum()
	{
		int total = 0;

		for (CodeValue value : values) {
			total += value.toInteger();
		}
	
		return total;
	}

}
