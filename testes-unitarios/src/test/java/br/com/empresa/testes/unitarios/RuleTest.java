package br.com.empresa.testes.unitarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class RuleTest {
	
	/*
	 	
	 		As Rules, de maneira geral, permitem adicionar comportamentos que serao executados antes e depois de cada metodo de teste. 
	 	
	 		O JUnit j� vem com algumas test rules predefinidas e permite, tambem, criarmos as nossas proprias Rules. 
	 		
	 		Ex: Uma das test rules oferecidas pelo JUnit � a ExpectedException. 
	 	
	 		Na pratica, o resultado � semelhante ao que pode ser feito com as anota��es @Before e @After, 
	 	
	 		Por�m s�o que de uma forma mais alto n�vel e com a possibilidade de reaproveitamento em outras classes de teste.
	  		
	  		Posso criar pastas temporarias para fazer testes, por exemplo.
	  		
	  		
	*/
	
	
	
	/*
	
	  	Cabe ressaltar algumas coisas sobre os test rules (variáveis anotadas com @Rule) para que elas funcionem adequadamente:

				1-) A vari�vel deve ser p�blica;
				2-) A vari�vel n�o pode ser est�tica (static);
				3-) A vari�vel deve ser um subtipo de TestRule, a classe do seu tipo deve implementar testRule.
	*/
	
	@Rule
    public TemporaryFolder tmpFolder = new TemporaryFolder();
 
    @Test
    public void shouldCreateNewFileInTemporaryFolder() throws IOException {
        File created = tmpFolder.newFile("file.txt");
 
        assertTrue(created.isFile());
        assertEquals(tmpFolder.getRoot(), created.getParentFile());
    }
}
