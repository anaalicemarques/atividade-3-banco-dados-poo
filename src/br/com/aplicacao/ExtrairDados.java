package br.com.aplicacao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ExtrairDados {
	public static void main(String[] args) {
		try {

			File arquivoXML = new File("passageiros.xml");

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			Document documento = (Document) dBuilder.parse(arquivoXML);

			documento.getDocumentElement().normalize();
			
			NodeList passageiros = documento.getElementsByTagName("passageiro");

			List<String> origens = new ArrayList<>();
			List<String> destinos = new ArrayList<>();

			int numeroPassageiros = passageiros.getLength();

			for (int i = 0; i < numeroPassageiros; i++) {
				Node passageiroNode = passageiros.item(i);

				if (passageiroNode.getNodeType() == Node.ELEMENT_NODE) {
					Element passageiroElement = (Element) passageiroNode;

					String origem = passageiroElement.getElementsByTagName("origem").item(0).getTextContent();
					String destino = passageiroElement.getElementsByTagName("destino").item(0).getTextContent();

					origens.add(origem);
					destinos.add(destino);
				}
			}

			System.out.println("Número de Passageiros: " + numeroPassageiros);
			System.out.println("Origens: " + origens);
			System.out.println("Destinos: " + destinos);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
