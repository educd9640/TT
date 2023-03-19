/*
 * HelloWorld! test Class 
 *  IMPORTANTE *********************************************
 *  
 *  REMOVE THESE CLASS AND THE DEFAULT USER CREATED FOR TEST!
*/
package ipn.escom.ballScore.action;


import javax.inject.Inject;

import ipn.escom.ballScore.business.LoginBI;



public class HelloAction extends BaseAction{
	@Inject
	LoginBI sv;
	
	public String execute(){
		//sv.createFirst();
		return "success";
	}

}
