package com.assignment_6_2.services;

import android.content.Context;

import com.assignment_6_2.domain.payment.Cheque;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Phinda Encore Tomson on 2016/05/07.
 */
public interface ChequeService {
    void addCheque(Context context,Cheque cheque);
}
