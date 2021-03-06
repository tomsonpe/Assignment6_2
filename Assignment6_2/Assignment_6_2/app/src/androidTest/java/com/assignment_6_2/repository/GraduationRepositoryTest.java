package com.assignment_6_2.repository;

import android.test.AndroidTestCase;

import com.assignment_6_2.domain.customer.GraduationCeremony;
import com.assignment_6_2.repositories.repository.customer.GraduationRepository;
import com.assignment_6_2.repositories.repositoryImplem.customer.GraduationRepositoryImplem;

import junit.framework.Assert;

import java.util.Set;

/**
 *Created by Phinda Encore Tomson on 4/21/2016.
 */
public class GraduationRepositoryTest extends AndroidTestCase {
    private static final String TAG="GRADUATION TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception{
        GraduationRepository gradRepo=new GraduationRepositoryImplem(this.getContext());
        GraduationCeremony createEntity=new GraduationCeremony.Builder()
                .no("50000")
                .name("Encore")
                .build();

        GraduationCeremony insertedEntity=gradRepo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE ", insertedEntity);

        Set<GraduationCeremony> grad=gradRepo.findAll();
        Assert.assertTrue(TAG + " READ ALL ", grad.size() > 0);

        GraduationCeremony entity=gradRepo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY ", entity);

        GraduationCeremony updateEntity=new GraduationCeremony.Builder()
                .copy(entity)
                .name("Encore")
                .build();
        gradRepo.update(updateEntity);
        GraduationCeremony newEntity=gradRepo.findById(id);
        Assert.assertEquals(TAG+" UPDATE ENTITY","Encore",newEntity.getName());

        gradRepo.delete(updateEntity);
        GraduationCeremony deletedEntity=gradRepo.findById(id);
        Assert.assertNull(TAG+" DELETE ",deletedEntity);
    }
}
