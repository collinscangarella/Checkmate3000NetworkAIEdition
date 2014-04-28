package edu.mccc.cos210.fp2014.cm.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamConstants;

import edu.mccc.cos210.fp2014.cm.game.Board;

/**
 * This handles marshaling our board class into an output stream and unmarshalling an input stream into a board class.
 */
public class MarshalHandler {
	JAXBContext jc;
	/**
	 * Unmarshals an input stream into a board object.
	 * @param in The input stream to unmarshal
	 * @return The board object which was represented by the input stream.
	 */
	public MarshalHandler(){
		try {
			jc = JAXBContext.newInstance(Board.class);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	public Board unmarshal(InputStream in) throws JAXBException{
			Unmarshaller um = this.jc.createUnmarshaller();
			Board b = (Board) um.unmarshal(new UncloseableInputStream(in));
			return b;
	}
	/**
	 * Marshals a board object into an OutputStream.
	 * @param b The board object to marshal
	 * @return The outputstream which represents the board object.
	 */
	public void marshal(Board b, OutputStream os) throws JAXBException, IOException {
			Marshaller m = this.jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(b, os);
	}
	public int bof(){
		return XMLStreamConstants.START_DOCUMENT;
	}
	public int eof(){
		return XMLStreamConstants.END_DOCUMENT;
	}
}
