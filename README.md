##RECYCLERVIEW


> A Recycler is responsible for managing scrapped or detached item views for reuse.

> A "scrapped" view is a view that is still attached to its parent RecyclerView but that has been marked for removal or reuse.

> Typical use of a Recycler by a RecyclerView.LayoutManager will be to obtain views for an adapter's data set representing the data at a given position or item ID. If the view to be reused is considered "dirty" the adapter will be asked to rebind it. If not, the view can be quickly reused by the LayoutManager with no further work. Clean views that have not requested layout may be repositioned by a LayoutManager without remeasurement.

RecyclerView 는 ViewHolder를 사용하여 리스트의 아이템이 표시될 재활용 뷰를 관리하는데 사용되며 아이템의 포지션에 따른 레이아웃의 배치를 결정하게 됩니다. 

또한 불필요한 뷰의 생성을 피하기 위해 레이아웃을 관리하는 역할을 하게 됩니다.
###### 화면에 보이는 아이템은 몇개 없는데 리스트에 표시해야되는 아이템을 쓸데없이 다 불러들여서 비효율을 초래하는게 아니라 화면을 스크롤 할때 보이는 만큼만 보여주고 불러놨던걸 재활용해서 효율적이란 소리 (ViewHolder를 통해서)

## Recycler View 사용방법
1. RecyclerView 레이아웃 지정
2. list item xml 생성
3. 액티비티에서 RecyclerView 생성
4. RecyclerView 와 Adapter 연결

### Adapter 생성 시

1. Adapter 내부에 ViewHolder InnerClass 생성
2. Adapter 상속(extends)을 RecyclerView.Adapter로 받고 <.ViewHolder>선언
3. Implement Method를 통해  OnCreateViewHolder, onBindHolder, getItemCount 생성
4. 기존 ListView 와 같이 설정

<pre>
<code>
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public RecyclerViewHolder(View itemView) {
            super(itemView);
        }
    }
}
</code>
</pre>

## Item 설정
Adapter onBindHolder 부분에서 setOnclickListener를 달아서 설정 할 수 있다
이때 inetnt를 통해 액티비티를 변경하려면 context 를 통해 넘겨야 하므로 생성자를 호출할 때
*Context* 선언을 해서 초기화 할 수 있어야 한다

> Context
>
> Interface to global information about an application environment. This is an abstract class whose implementation is provided by the Android system. It allows access to application-specific resources and classes, as well as up-calls for application-level operations such as launching activities, broadcasting and receiving intents, etc. 
>
