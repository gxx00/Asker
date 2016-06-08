package com.example.gxx.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gxx.asker.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment {


   public View findviewbyID(int id)
   {
       return getView().findViewById(id);
   }





}
