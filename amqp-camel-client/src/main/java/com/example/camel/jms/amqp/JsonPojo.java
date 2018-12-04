package com.example.camel.jms.amqp;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = ",")
public class JsonPojo {
	
    @DataField(pos = 1)
	private String firstWord;
    @DataField(pos = 2)
	private String secondWord;
    
	public String getFirstWord() {
		return firstWord;
	}
	public void setFirstWord(String firstWord) {
		this.firstWord = firstWord;
	}
	public String getSecondWord() {
		return secondWord;
	}
	public void setSecondWord(String secondWord) {
		this.secondWord = secondWord;
	}
	@Override
	public String toString() {
		return "JsonPojo [firstWord=" + firstWord + ", secondWord=" + secondWord + "]";
	}

}
