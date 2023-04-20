package matt.springframework.sfgpetclinic.services;

import matt.springframework.sfgpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);
}
