package com.kukjinman.salarytimer.databinding;
import com.example.salarytimer.R;
import com.kukjinman.salarytimer.BR;
import com.kukjinman.salarytimer.ui.viewmodel.mainpages.MainFViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentMainBindingImpl extends FragmentMainBinding {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.constraintLayout2, 5);
        sViewsWithIds.put(R.id.main_text1, 6);
        sViewsWithIds.put(R.id.main_linear, 7);
        sViewsWithIds.put(R.id.salaryInput, 8);
        sViewsWithIds.put(R.id.main_text2, 9);
        sViewsWithIds.put(R.id.main_text3, 10);
        sViewsWithIds.put(R.id.main_linear2, 11);
        sViewsWithIds.put(R.id.salaryText, 12);
        sViewsWithIds.put(R.id.main_linear3, 13);
        sViewsWithIds.put(R.id.memo_layout_startTime_hr_box, 14);
        sViewsWithIds.put(R.id.memo_startTime_hr_up_btn, 15);
        sViewsWithIds.put(R.id.memo_startTime_hr_down_btn, 16);
        sViewsWithIds.put(R.id.startTime_Colon, 17);
        sViewsWithIds.put(R.id.memo_layout_startTime_min_box, 18);
        sViewsWithIds.put(R.id.memo_startTime_min_up_btn, 19);
        sViewsWithIds.put(R.id.memo_startTime_min_down_btn, 20);
        sViewsWithIds.put(R.id.Tilde, 21);
        sViewsWithIds.put(R.id.memo_layout_endTime_hr_box, 22);
        sViewsWithIds.put(R.id.memo_endTime_hr_up_btn, 23);
        sViewsWithIds.put(R.id.memo_endTime_hr_down_btn, 24);
        sViewsWithIds.put(R.id.endTime_Colon, 25);
        sViewsWithIds.put(R.id.memo_layout_endTime_min_box, 26);
        sViewsWithIds.put(R.id.memo_endTime_min_up_btn, 27);
        sViewsWithIds.put(R.id.memo_endTime_min_down_btn, 28);
        sViewsWithIds.put(R.id.main_textDescription, 29);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 30, sIncludes, sViewsWithIds));
    }
    private FragmentMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4
            , (android.widget.TextView) bindings[21]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[5]
            , (android.widget.TextView) bindings[25]
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[7]
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[11]
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[13]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[29]
            , (android.widget.TextView) bindings[3]
            , (android.widget.ImageButton) bindings[24]
            , (android.widget.ImageButton) bindings[23]
            , (android.widget.TextView) bindings[4]
            , (android.widget.ImageButton) bindings[28]
            , (android.widget.ImageButton) bindings[27]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[22]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[26]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[14]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[18]
            , (android.widget.TextView) bindings[1]
            , (android.widget.ImageButton) bindings[16]
            , (android.widget.ImageButton) bindings[15]
            , (android.widget.TextView) bindings[2]
            , (android.widget.ImageButton) bindings[20]
            , (android.widget.ImageButton) bindings[19]
            , (android.widget.EditText) bindings[8]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[17]
            );
        this.constraintLayout1.setTag(null);
        this.memoEndTimeHr.setTag(null);
        this.memoEndTimeMin.setTag(null);
        this.memoStartTimeHr.setTag(null);
        this.memoStartTimeMin.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20L;
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
        if (BR.viewModel == variableId) {
            setViewModel((MainFViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable MainFViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelStartHour((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeViewModelEndHour((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeViewModelEndMinute((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeViewModelStartMinute((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelStartHour(androidx.lifecycle.MutableLiveData<java.lang.String> ViewModelStartHour, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelEndHour(androidx.lifecycle.MutableLiveData<java.lang.String> ViewModelEndHour, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelEndMinute(androidx.lifecycle.MutableLiveData<java.lang.String> ViewModelEndMinute, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelStartMinute(androidx.lifecycle.MutableLiveData<java.lang.String> ViewModelStartMinute, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
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
        java.lang.String viewModelEndMinuteGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelStartHour = null;
        java.lang.String viewModelStartMinuteGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelEndHour = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelEndMinute = null;
        java.lang.String viewModelStartHourGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelStartMinute = null;
        java.lang.String viewModelEndHourGetValue = null;
        MainFViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0x3fL) != 0) {


            if ((dirtyFlags & 0x31L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.startHour
                        viewModelStartHour = viewModel.getStartHour();
                    }
                    updateLiveDataRegistration(0, viewModelStartHour);


                    if (viewModelStartHour != null) {
                        // read viewModel.startHour.getValue()
                        viewModelStartHourGetValue = viewModelStartHour.getValue();
                    }
            }
            if ((dirtyFlags & 0x32L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.endHour
                        viewModelEndHour = viewModel.getEndHour();
                    }
                    updateLiveDataRegistration(1, viewModelEndHour);


                    if (viewModelEndHour != null) {
                        // read viewModel.endHour.getValue()
                        viewModelEndHourGetValue = viewModelEndHour.getValue();
                    }
            }
            if ((dirtyFlags & 0x34L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.endMinute
                        viewModelEndMinute = viewModel.getEndMinute();
                    }
                    updateLiveDataRegistration(2, viewModelEndMinute);


                    if (viewModelEndMinute != null) {
                        // read viewModel.endMinute.getValue()
                        viewModelEndMinuteGetValue = viewModelEndMinute.getValue();
                    }
            }
            if ((dirtyFlags & 0x38L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.startMinute
                        viewModelStartMinute = viewModel.getStartMinute();
                    }
                    updateLiveDataRegistration(3, viewModelStartMinute);


                    if (viewModelStartMinute != null) {
                        // read viewModel.startMinute.getValue()
                        viewModelStartMinuteGetValue = viewModelStartMinute.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x32L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.memoEndTimeHr, viewModelEndHourGetValue);
        }
        if ((dirtyFlags & 0x34L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.memoEndTimeMin, viewModelEndMinuteGetValue);
        }
        if ((dirtyFlags & 0x31L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.memoStartTimeHr, viewModelStartHourGetValue);
        }
        if ((dirtyFlags & 0x38L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.memoStartTimeMin, viewModelStartMinuteGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.startHour
        flag 1 (0x2L): viewModel.endHour
        flag 2 (0x3L): viewModel.endMinute
        flag 3 (0x4L): viewModel.startMinute
        flag 4 (0x5L): viewModel
        flag 5 (0x6L): null
    flag mapping end*/
    //end
}