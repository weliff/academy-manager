package br.com.academyflash.GUI;

import javax.swing.text.AttributeSet;  
import javax.swing.text.BadLocationException;  
  
public class ControlarEntradaTexto extends FixedLengthDocument  {  
    public ControlarEntradaTexto(int maxlen) {
		super(maxlen);
	}

	@Override  
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {  
        if(Character.isLetter(str.charAt(0))||str.equals(" "))  
            super.insertString(offs, str.toUpperCase(), a);  
    }  
}  