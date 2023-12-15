package com.kukjinman.salarytimer.databinding;
import com.example.salarytimer.R;
import com.kukjinman.salarytimer.BR;
import com.kukjinman.salarytimer.ui.viewmodel.mainpages.MainF2ViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentMain2BindingImpl extends FragmentMain2Binding {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.constraintLayout2, 2);
        sViewsWithIds.put(R.id.main2_linear, 3);
        sViewsWithIds.put(R.id.main2_text2, 4);
        sViewsWithIds.put(R.id.main2_text3, 5);
    }
    // views
    @NonNull
    private final android.widget.TextView mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentMain2BindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private FragmentMain2BindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[2]
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[3]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[5]
            );
        this.constraintLayout1.setTag(null);
        this.mboundView1 = (android.widget.TextView) bindings[1];
        this.mboundView1.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.viewModel2 == variableId) {
            setViewModel2((MainF2ViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel2(@Nullable MainF2ViewModel ViewModel2) {
        this.mViewModel2 = ViewModel2;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.viewModel2);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModel2TodayCurSalary((androidx.lifecycle.MutableLiveData<java.lang.Number>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModel2TodayCurSalary(androidx.lifecycle.MutableLiveData<java.lang.Number> ViewModel2TodayCurSalary, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.Number viewModel2TodayCurSalaryGetValue = null;
        MainF2ViewModel viewModel2 = mViewModel2;
        androidx.lifecycle.MutableLiveData<java.lang.Number> viewModel2TodayCurSalary = null;
        java.lang.String stringValueOfViewModel2TodayCurSalary = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (viewModel2 != null) {
                    // read viewModel2.todayCurSalary
                    viewModel2TodayCurSalary = viewModel2.getTodayCurSalary();
                }
                updateLiveDataRegistration(0, viewModel2TodayCurSalary);


                if (viewModel2TodayCurSalary != null) {
                    // read viewModel2.todayCurSalary.getValue()
                    viewModel2TodayCurSalaryGetValue = viewModel2TodayCurSalary.getValue();
                }


                // read String.valueOf(viewModel2.todayCurSalary.getValue())
                stringValueOfViewModel2TodayCurSalary = java.lang.String.valueOf(viewModel2TodayCurSalaryGetValue);
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, stringValueOfViewModel2TodayCurSalary);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel2.todayCurSalary
        flag 1 (0x2L): viewModel2
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}