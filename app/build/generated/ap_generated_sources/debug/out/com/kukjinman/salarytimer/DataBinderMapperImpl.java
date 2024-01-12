package com.kukjinman.salarytimer;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.kukjinman.salarytimer.databinding.ActivityMainBindingImpl;
import com.kukjinman.salarytimer.databinding.FragmentMain2BindingImpl;
import com.kukjinman.salarytimer.databinding.FragmentMain3BindingImpl;
import com.kukjinman.salarytimer.databinding.FragmentMainBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYMAIN = 1;

  private static final int LAYOUT_FRAGMENTMAIN = 2;

  private static final int LAYOUT_FRAGMENTMAIN2 = 3;

  private static final int LAYOUT_FRAGMENTMAIN3 = 4;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(4);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.kukjinman.salarytimer.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.kukjinman.salarytimer.R.layout.fragment_main, LAYOUT_FRAGMENTMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.kukjinman.salarytimer.R.layout.fragment_main2, LAYOUT_FRAGMENTMAIN2);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.kukjinman.salarytimer.R.layout.fragment_main3, LAYOUT_FRAGMENTMAIN3);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMAIN: {
          if ("layout/fragment_main_0".equals(tag)) {
            return new FragmentMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_main is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMAIN2: {
          if ("layout/fragment_main2_0".equals(tag)) {
            return new FragmentMain2BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_main2 is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMAIN3: {
          if ("layout/fragment_main3_0".equals(tag)) {
            return new FragmentMain3BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_main3 is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(4);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "viewModel");
      sKeys.put(2, "viewModel2");
      sKeys.put(3, "viewModel3");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(4);

    static {
      sKeys.put("layout/activity_main_0", com.kukjinman.salarytimer.R.layout.activity_main);
      sKeys.put("layout/fragment_main_0", com.kukjinman.salarytimer.R.layout.fragment_main);
      sKeys.put("layout/fragment_main2_0", com.kukjinman.salarytimer.R.layout.fragment_main2);
      sKeys.put("layout/fragment_main3_0", com.kukjinman.salarytimer.R.layout.fragment_main3);
    }
  }
}
