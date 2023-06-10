package matt.springframework.sfgpetclinic.bootstrap;

import matt.springframework.sfgpetclinic.model.*;
import matt.springframework.sfgpetclinic.services.OwnerService;
import matt.springframework.sfgpetclinic.services.PetTypeService;
import matt.springframework.sfgpetclinic.services.SpecialtiesService;
import matt.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;

    private final VetService vetService;

    private final PetTypeService petTypeService;

    private final SpecialtiesService specialtiesService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtiesService specialtiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }



    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Specialty radiology = new Specialty();
        radiology.setDescription("radiology");
        Specialty savedRadiology = specialtiesService.save(radiology);

        Specialty surgeon = new Specialty();
        surgeon.setDescription("surgeon");
        Specialty savedSurgeon = specialtiesService.save(surgeon);

        Specialty dentist = new Specialty();
        dentist.setDescription("dentist");
        Specialty savedDentist = specialtiesService.save(dentist);

        Owner owner1 = new Owner();
        owner1.setFirstName("Matt");
        owner1.setLastName("Birhane");
        owner1.setAddress("15 Churchill");
        owner1.setCity("Addis Ababa");
        owner1.setTelephone("1234567890");

        Pet mattPet = new Pet();
        mattPet.setName("Draco");
        mattPet.setPetType(savedDogPetType);
        mattPet.setBirthDate(LocalDate.now());
        mattPet.setOwner(owner1);

        owner1.getPets().add(mattPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Brivet");
        owner2.setLastName("Squet");
        owner2.setAddress("12 Janhoy");
        owner2.setCity("Addis Bahir Dar");
        owner2.setTelephone("0987654321");

        Pet brivetPet = new Pet();
        brivetPet.setName("Malfoy");
        brivetPet.setPetType(savedCatPetType);
        brivetPet.setBirthDate(LocalDate.now());
        brivetPet.setOwner(owner2);

        owner2.getPets().add(brivetPet);

        ownerService.save(owner2);


        System.out.println("Loaded owners---");

        Vet vet1 = new Vet();
        vet1.setFirstName("Akal");
        vet1.setLastName("Mulu");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Born");
        vet2.setLastName("Thron");
        vet2.getSpecialities().add(savedRadiology);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
