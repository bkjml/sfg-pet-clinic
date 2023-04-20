package matt.springframework.sfgpetclinic.bootstrap;

import matt.springframework.sfgpetclinic.model.Owner;
import matt.springframework.sfgpetclinic.model.Vet;
import matt.springframework.sfgpetclinic.services.OwnerService;
import matt.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;

    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Matt");
        owner1.setLastName("Birhane");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Brivet");
        owner2.setLastName("Squet");
        ownerService.save(owner2);
        System.out.println("Loaded owners---");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Akal");
        vet1.setLastName("Mulu");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Born");
        vet2.setLastName("Thron");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");


    }
}
