package com.assignment_6_2.repository;

import android.test.AndroidTestCase;

import com.assignment_6_2.domain.customer.Funerals;
import com.assignment_6_2.repositories.repository.customer.FuneralRepository;
import com.assignment_6_2.repositories.repositoryImplem.customer.FuneralRepositoryImplem;

import junit.framework.Assert;

import java.util.Set;

/**
 *Created by Phinda Encore Tomson on 4/21/2016.
 */
public class FuneralRepositoryTest extends AndroidTestCase {
    private static final String TAG="FUNERALS TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception{
        FuneralRepository funRepo=new FuneralRepositoryImplem(this.getContext());
        Funerals createEntity=new Funerals.Builder()
                .no("50000")
                .name("Encore")
                .build();

        Funerals insertedEntity=funRepo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE ", insertedEntity);

        Set<Funerals> funeral=funRepo.findAll();
        Assert.assertTrue(TAG + " READ ALL ", funeral.size() > 0);

        Funerals entity=funRepo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY ", entity);

        Funerals updateEntity=new Funerals.Builder()
                .copy(entity)
                .name("Encore")
                .build();
        funRepo.update(updateEntity);
        Funerals newEntity=funRepo.findById(id);
        Assert.assertEquals(TAG+" UPDATE ENTITY","Encore",newEntity.getName());

        funRepo.delete(updateEntity);
        Funerals deletedEntity=funRepo.findById(id);
        Assert.assertNull(TAG+" DELETE ",deletedEntity);
    }
}
