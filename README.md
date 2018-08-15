# EmptyRecyclerView
EmptyRecyclerView
 <p>
# How to use
 <p>
 Add your recycler view in the relativelayout if not
<RelativeLayout
android:layout_width="match_parent"
android:layout_height="match_parent"
android:layout_below="@+id/header"
android:layout_margin="10dp">
<p>
<com.example.emptyrecyclerview.EmptyRecyclerView
android:id="@+id/recyclerView"
android:layout_width="match_parent"
android:layout_height="match_parent">
<p>
</com.example.emptyrecyclerview.EmptyRecyclerView>
</RelativeLayout>
<p>
Then you can use as below
<p>
 * For setting TextView Layout Gravity in the parent view
//recyclerView.setEmptyViewGravity(RelativeLayout.CENTER_HORIZONTAL);
 * For setting TextView Layout Params
recyclerView.setEmptyViewParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
<p>
 * Empty Recylerview and its EmptyTextView
EmptyRecyclerView recyclerView = findViewById(R.id.recyclerView);
EmptyRecyclerView.EmptyTextView emptyTextView = recyclerView.withEmptyView(this);
emptyTextView.setTextColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
emptyTextView.setText("No Records found Click Load Data Button to show the data");
emptyTextView.setGravity(Gravity.CENTER);
emptyTextView.built(); IMPORTANT IS you call built after setting the property
recyclerView.setEmptyViewStr("No Records found Click Load Data Button to show the data");
<p>
