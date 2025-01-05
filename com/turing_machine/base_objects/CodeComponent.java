package com.turing_machine.base_objects;

public class CodeComponent {

	private final CodeIndex index;

	private final CodeValue value;

	public CodeComponent(CodeIndex index, CodeValue value) {

		this.index = index;
		this.value = value;
	}

	public CodeIndex getIndex() {
		return index;
	}

	public CodeValue getValue() {
		return value ;
	}

	public boolean equals(CodeComponent other_component)
	{
		return this.index == other_component.index && this.value == other_component.value;
	}

}
