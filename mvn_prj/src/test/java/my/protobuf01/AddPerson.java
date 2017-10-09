package my.protobuf01;

import org.junit.Test;


import com.example.tutorial.AddressBookProtos.AddressBook;
import com.example.tutorial.AddressBookProtos.Person;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintStream;

public class AddPerson {
  // This function fills in a Person message based on user input.
  static Person PromptForAddress(BufferedReader stdin,
                                 PrintStream stdout) throws IOException {
    Person.Builder person = Person.newBuilder();

    person.setId(100);

    person.setName("TOM");

    String email = "TOM.ST@aa.com";
    if (email.length() > 0) {
      person.setEmail(email);
    }


      Person.PhoneNumber.Builder phoneNumber =  Person.PhoneNumber.newBuilder().setNumber("110");
      phoneNumber.setType(Person.PhoneType.MOBILE);
      person.addPhones(phoneNumber);

      Person.PhoneNumber.Builder phoneNumber1 =  Person.PhoneNumber.newBuilder().setNumber("23456778");
      phoneNumber1.setType(Person.PhoneType.WORK);
      person.addPhones(phoneNumber1);

    return person.build();
  }

  // Main function:  Reads the entire address book from a file,
  //   adds one person based on user input, then writes it back out to the same
  //   file.
  //
  @Test
  public void Test01() throws Exception {
    
    String filePath=System.getenv("data_file");
    System.out.println("------ yes -----");
    AddressBook.Builder addressBook = AddressBook.newBuilder();

    // Read the existing address book.
    try {
      addressBook.mergeFrom(new FileInputStream(filePath));
    } catch (FileNotFoundException e) {
      System.out.println(filePath + ": File not found.  Creating a new file.");
    }

    // Add an address.
    addressBook.addPeople(
      PromptForAddress(new BufferedReader(new InputStreamReader(System.in)),
                       System.out));

    // Write the new address book back to disk.
    FileOutputStream output = new FileOutputStream(filePath);
    addressBook.build().writeTo(output);
    output.close();
  }
}
