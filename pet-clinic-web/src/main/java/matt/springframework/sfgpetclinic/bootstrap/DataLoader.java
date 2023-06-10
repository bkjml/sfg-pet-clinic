package matt.springframework.sfgpetclinic.bootstrap;

import matt.springframework.sfgpetclinic.model.Owner;
import matt.springframework.sfgpetclinic.model.PetType;
import matt.springframework.sfgpetclinic.model.Vet;
import matt.springframework.sfgpetclinic.services.OwnerService;
import matt.springframework.sfgpetclinic.services.PetTypeService;
import matt.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;

    private final VetService vetService;

    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Matt");
        owner1.setLastName("Birhane");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Brivet");
        owner2.setLastName("Squet");
        ownerService.save(owner2);
        System.out.println("Loaded owners---");

        Vet vet1 = new Vet();
        vet1.setFirstName("Akal");
        vet1.setLastName("Mulu");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Born");
        vet2.setLastName("Thron");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");


    }
}
