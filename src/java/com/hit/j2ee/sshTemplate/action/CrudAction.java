package com.hit.j2ee.sshTemplate.action;

import java.io.Serializable;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

@SuppressWarnings("serial")
public abstract class CrudAction<T,PK extends Serializable> 
extends BaseAction
implements ModelDriven<T>,Preparable{

	
	
	
}
