package com.assignment_6_2.services;

import android.content.Context;

import com.assignment_6_2.domain.customer.GraduationCeremony;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Phinda Encore Tomson on 2016/05/07.
 */
public interface GraduationCeremonyService {
    void addGrad(Context context,GraduationCeremony grad);
}
