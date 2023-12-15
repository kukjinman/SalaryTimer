package com.kukjinman.salarytimer.databinding;
import com.example.salarytimer.R;
import com.kukjinman.salarytimer.BR;
import com.kukjinman.salarytimer.ui.viewmodel.mainpages.MainF3ViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentMain3BindingImpl extends FragmentMain3Binding {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.constraintLayout2, 2);
        sViewsWithIds.put(R.id.main2_linear, 3);
    }
    // views
    @NonNull
    private final android.widget.TextView mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentMain3BindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private FragmentMain3BindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[2]
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[3]
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
        if (BR.viewModel3 == variableId) {
            setViewModel3((MainF3ViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel3(@Nullable MainF3ViewModel ViewModel3) {
        this.mViewModel3 = ViewModel3;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.viewModel3);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModel3MonthSalarySum((androidx.lifecycle.MutableLiveData<java.lang.Number>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModel3MonthSalarySum(androidx.lifecycle.MutableLiveData<java.lang.Number> ViewModel3MonthSalarySum, int fieldId) {
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
        androidx.lifecycle.MutableLiveData<java.lang.Number> viewModel3MonthSalarySum = null;
        java.lang.Number viewModel3MonthSalarySumGetValue = null;
        java.lang.String stringValueOfViewModel3MonthSalarySum = null;
        MainF3ViewModel viewModel3 = mViewModel3;

        if ((dirtyFlags & 0x7L) != 0) {



                if (viewModel3 != null) {
                    // read viewModel3.monthSalarySum
                    viewModel3MonthSalarySum = viewModel3.getMonthSalarySum();
                }
                updateLiveDataRegistration(0, viewModel3MonthSalarySum);


                if (viewModel3MonthSalarySum != null) {
                    // read viewModel3.monthSalarySum.getValue()
                    viewModel3MonthSalarySumGetValue = viewModel3MonthSalarySum.getValue();
                }


                // read String.valueOf(viewModel3.monthSalarySum.getValue())
                stringValueOfViewModel3MonthSalarySum = java.lang.String.valueOf(viewModel3MonthSalarySumGetValue);
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, stringValueOfViewModel3MonthSalarySum);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel3.monthSalarySum
        flag 1 (0x2L): viewModel3
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}