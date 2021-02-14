package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Compte;
import com.example.demo.entities.Operation;
import com.example.metier.IBanqueMetier;

@Controller
public class BanqueController {
@Autowired
	private IBanqueMetier banqueMetier;
	
    @RequestMapping("/operations")
    public String index() {
    	return "comptes";
    }
    
	@RequestMapping("/consultercompte")  //càd , quand je tape : localhost/consulterCompte j'aurai une vue qui s'appelle comptes.html
	public String consulterCompte(Model model, String codeCompte,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size) {   //cette methode retourne une vue tous simplement
		
		model.addAttribute("codeCompte",codeCompte);
		
		try {
			
			Compte compte=banqueMetier.getCompte(codeCompte);  //le bloc de try catch est à cause de la generation d'exception de la methode getCompte
			Page<Operation>  pageOperations = banqueMetier.listOperation(codeCompte ,page, size);
			model.addAttribute("listOperations",pageOperations.getContent());
			int[] pages=new int[pageOperations.getTotalPages()];
			model.addAttribute("pages", pages);
			model.addAttribute("compte",compte);
	 
		}catch (Exception e) {
			model.addAttribute("exception",e);
		}
		

		return "comptes"; //càd : le nom de la vue est : comptes.html
	}
	
	
	/*@RequestMapping("/operations")  //càd , quand je tape : localhost/operations j'aurai une vue qui s'appelle comptes.html
	public String index() {   //cette methode retourne une vue tous simplement
		
		return "comptes"; //càd : le nom de la vue est : comptes.html
		
	}*/
	
	@RequestMapping(value="/saveOperation",method=RequestMethod.POST)   
	public String saveOperation(Model model,String typeOperation, String codeCompte,double montant, String codeCompte2) {   //cette methode retourne une vue tous simplement
		
		try {
			if(typeOperation.equals("VERS")) {
				
				banqueMetier.verser(codeCompte,montant);
			} else if(typeOperation.equals("RETR")) {
				
				banqueMetier.retirer(codeCompte,montant);
			} else  {
				
				banqueMetier.virement(codeCompte,codeCompte2,montant);
			} 
		}catch (Exception e) {
			model.addAttribute("error",e);
			return "redirect:/consultercompte?codeCompte="+codeCompte+"&error="+e.getMessage();  
		}
		 
		
		return "redirect:/consultercompte?codeCompte="+codeCompte;  
	}
}
