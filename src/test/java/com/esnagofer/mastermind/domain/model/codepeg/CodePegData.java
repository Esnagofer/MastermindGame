/*
 * 
 */
package com.esnagofer.mastermind.domain.model.codepeg;

/**
 * The Class CodePegData.
 */
public class CodePegData {

	/**
	 * Four code pegs with same color.
	 *
	 * @param color the color
	 * @return the code peg[]
	 */
	public static CodePeg[] fourCodePegsWithSameColor(CodePegColor color){
		return new CodePeg[] {
			CodePeg.newInstance(color), 
			CodePeg.newInstance(color), 
			CodePeg.newInstance(color), 
			CodePeg.newInstance(color)
		};
	}

	/**
	 * Four code pegs.
	 *
	 * @return the code peg[]
	 */
	public static CodePeg[] fourCodePegs(){
		return new CodePeg[] {
			CodePeg.newInstance(), 
			CodePeg.newInstance(), 
			CodePeg.newInstance(), 
			CodePeg.newInstance()
		};
	}
	
}
