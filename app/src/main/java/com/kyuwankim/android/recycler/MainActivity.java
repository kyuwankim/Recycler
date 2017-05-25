package com.kyuwankim.android.recycler;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView listview ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (RecyclerView)findViewById(R.id.recyclerview);

        // 1. 데이터
        ArrayList<Data> datas = Loader.getData(this);

        // 2. 아답터

        // 3. 연결

        // 4. 레이아웃 매니저
    }
}

class CustomRecycler extends RecyclerView.Adapter<CustomRecycler.Holder>{

    ArrayList<Data> datas;
    Context context;
    public CustomRecycler(ArrayList<Data> datas, Context context){
        this.datas = datas;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);




        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView no;
        TextView title;


        public Holder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.image);
            no = (TextView) itemView.findViewById(R.id.txtNo);
            title = (TextView) itemView.findViewById(R.id.txtTitle);

        }
    }

}

class Loader {
    public static ArrayList<Data> getData(Context context) {
        ArrayList<Data> result = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Data data = new Data();
            data.no = i;
            data.title = "안드로보이";

            data.setImage("ic_launcher" + i, context);

            result.add(data);
        }
        return result;
    }
}

class Data {
    public int no;
    public String title;
    public String image;
    public int resId;

    public void setImage(String str, Context context) {
        image = str;
        // 문자열로 리소스 아이디 가져오기
        resId = context.getResources().getIdentifier(image, "mipmap", context.getPackageName());
    }
}
