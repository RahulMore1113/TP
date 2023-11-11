package com.rahul;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.rahul.bo.MarriageSeeker;
import com.rahul.service.IMatrimonyServiceMgmt;

@SpringBootApplication
public class DaoSpringDataJpaBlobclobAppApplication {

	public static void main(String[] args) throws IOException {

		ApplicationContext context = SpringApplication.run(DaoSpringDataJpaBlobclobAppApplication.class, args);

		IMatrimonyServiceMgmt service = context.getBean(IMatrimonyServiceMgmt.class);

//		Scanner sc = new Scanner(System.in);
//
//		System.out.println("Enter the name :: ");
//		String name = sc.next();
//
//		System.out.println("Enter the address :: ");
//		String address = sc.next();
//
//		System.out.println("Enter the photo path :: ");
//		String photo = sc.next();
//
//		System.out.println("Enter the Bio-Data path :: ");
//		String bioData = sc.next();
//
//		System.out.println("Is person is indian :: ");
//		boolean indian = sc.nextBoolean();
//
//		InputStream is = new FileInputStream(photo);
//		byte[] photoData = new byte[is.available()];
//		is.read(photoData);
//
//		File file = new File(bioData);
//		FileReader reader = new FileReader(file);
//		char[] bioDataContent = new char[(int) file.length()];
//		reader.read(bioDataContent);
//
//		MarriageSeeker seeker = new MarriageSeeker(name, address, photoData, LocalDateTime.of(2000, 02, 07, 10, 45),
//				bioDataContent, indian);
//
//		System.out.println(service.registerMarriageSeeker(seeker));
//
//		reader.close();
//		is.close();
//		sc.close();

		Optional<MarriageSeeker> optional = service.searchSeekerById(1L);
		if (optional.isPresent()) {
			MarriageSeeker seeker = optional.get();
			System.out.println(seeker.getId() + " " + seeker.getName() + " " + seeker.getAddress() + " "
					+ seeker.getBioData() + " " + seeker.getIndian());

			OutputStream os = new FileOutputStream("retrive_image.jpg");
			os.write(seeker.getPhoto());
			os.flush();

			Writer writer = new FileWriter("retrieve bio-data.txt");
			writer.write(seeker.getBioData());
			writer.flush();

			writer.close();
			os.close();

			System.out.println("LOBS are retrieved...");
		} else {
			System.out.println("Record not found...");
		}

		((ConfigurableApplicationContext) context).close();

	}

}
