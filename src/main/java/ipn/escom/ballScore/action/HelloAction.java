/*
 * HelloWorld! test Class 
 *  IMPORTANTE *********************************************
 *  
 *  REMOVE THESE CLASS AND THE DEFAULT USER CREATED FOR TEST!
*/
package ipn.escom.ballScore.action;


import javax.inject.Inject;

import com.opensymphony.xwork2.Action;

import ipn.escom.ballScore.business.LoginBI;



public class HelloAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	@Inject
	LoginBI sv;
	
	public String execute(){
		//sv.createFirst();
		return Action.SUCCESS;
	}

}
