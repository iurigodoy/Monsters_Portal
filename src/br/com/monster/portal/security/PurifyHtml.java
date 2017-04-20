package br.com.monster.portal.security;

import org.owasp.validator.html.AntiSamy;
import org.owasp.validator.html.CleanResults;
import org.owasp.validator.html.PolicyException;
import org.owasp.validator.html.ScanException;

public class PurifyHtml {
	
	public String main(String suspeito) {
		AntiSamy as = new AntiSamy();
		CleanResults cr;
		try {
			cr = as.scan(suspeito);
			String limpo = cr. getCleanHTML();
			return limpo;
		} catch (ScanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PolicyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
