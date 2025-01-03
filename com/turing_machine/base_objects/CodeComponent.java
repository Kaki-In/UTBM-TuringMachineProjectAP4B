package com.turing_machine.base_objects;

public class CodeComponent {

	private CodeIndex index;

	private CodeValue value;

	public CodeComponent(CodeIndex index, CodeValue value) {

		this.index=index;
		this.value=value;
	}

	public CodeIndex getIndex() {
		return index;
	}

	public CodeValue getValue() {
		return value ;
	}

}
