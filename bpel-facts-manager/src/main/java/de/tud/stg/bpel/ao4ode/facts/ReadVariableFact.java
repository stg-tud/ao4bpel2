package de.tud.stg.bpel.ao4ode.facts;

/**
 * Use this fact whenever a variable is read! 
 * 
 * @author A. Look
 *
 */
public interface ReadVariableFact extends DynamicFact {

	String getVarName();

}
