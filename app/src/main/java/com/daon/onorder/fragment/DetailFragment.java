package com.daon.onorder.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.daon.onorder.GlideApp;
import com.daon.onorder.MainActivity;
import com.daon.onorder.MenuActivity;
import com.daon.onorder.Model.MenuModel;
import com.daon.onorder.Model.OrderModel;
import com.daon.onorder.R;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class DetailFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private String url;
    private String name;
    private String price;
    private String info;
    private String code;

    CheckBox opt1;
    CheckBox opt2;
    CheckBox opt3;
    CheckBox opt4;
    CheckBox opt5;
    CheckBox opt6;
    CheckBox opt7;
    CheckBox opt8;
    CheckBox opt9;

    String str_opt1;
    String str_opt2;
    String str_opt3;
    String str_opt4;
    String str_opt5;
    String str_opt6;
    String str_opt7;
    String str_opt8;
    String str_opt9;


    View RootView;

    ImageView menuImg;
    TextView nameText;
    TextView nameTextsub;
    TextView priceText;
    TextView infoText;
    TextView close;
    TextView detailCount;
    LinearLayout add_menu;
    LinearLayout check_layout;
    LinearLayout radio;
    RadioGroup radioGroup;
    RadioGroup radioGroup1;
    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio11;
    RadioButton radio12;
    RadioButton radio13;
    RadioButton radio14;
    RadioButton radio15;
    RadioButton radio16;
    RadioButton radio17;

    RadioButton radio21;
    RadioButton radio22;
    RadioButton radio23;
    RadioButton radio24;
    RadioButton radio25;
    RadioButton radio26;

    CheckBox plusCheck;
    LinearLayout radiolayout2;
    LinearLayout radiolayout1;

    ImageView plus;
    ImageView minus;
    String dPrice;

    TextView radioText;
    TextView eventText;
    TextView info2;
    LinearLayout detail_back;




    int position;
    public DetailFragment() {}

    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            ArrayList<MenuModel> model =  (ArrayList<MenuModel>) getArguments().get("list");
            position = (int) getArguments().get("position");

            url = model.get(position).getPicurl();
            name = model.get(position).getName();
            info = model.get(position).getInfo();
            price = model.get(position).getPrice();
            dPrice = model.get(position).getPrice();
            code = model.get(position).getCode();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RootView = inflater.inflate(R.layout.fragment_detail, container, false);
        initViews();
        return RootView;
    }
    public void initViews(){

        SharedPreferences preferences = this.getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
        detail_back = RootView.findViewById(R.id.detail_back);
        if (preferences.getString("storecode", "").equals("ots")){
            detail_back.setBackgroundResource(R.drawable.datail_back);
        }
        info2 = RootView.findViewById(R.id.detailfragment_text_info2);
        plusCheck = RootView.findViewById(R.id.check_plus);
        add_menu = RootView.findViewById(R.id.detailfragment_layout_add);

        if (name.contains("토종닭손칼국수")){
            info2.setText("토종닭에서 우려난 진하고 구수한 맛과 메밀가루의 걸쭉한 맛을 이룬 육수\n\n직접 뒷마당에서 키워 스트레스 받지 않은 건강한 닭\n\n\n1인 1메뉴 주문.\n\n2인이상 주문시 큰 그릇에 제공됩니다.");
            plusCheck.setVisibility(View.VISIBLE);
        }
        if (name.contains("버섯칼국수")){
            info2.setText("버섯향이 가득하며 담백하고 깔끔한 맛의 육수\n\n무공해로 재배한 뒷마당표 표고버섯.\n\n\n1인 1메뉴 주문.\n\n2인이상 주문시 큰 그릇에 제공됩니다.");
            plusCheck.setVisibility(View.VISIBLE);
        }
        if (name.contains("닭개장")){
            info2.setText("국산 태양초를 이용한 양념장 숙성으로 구수하게 매운맛과 제주 고사리와 뒷마당표 표고버섯등 야채들의 풍성함이 조화롭게 어울리는 맛\n\n뒷마당에서 태어난 청계유정란을 사용하여 가성비 최고의 닭개장\n\n\n공기밥 제공됩니다.");
        }
        if (name.contains("냉메밀")){
            plusCheck.setVisibility(View.VISIBLE);
            info2.setText("소소한 비법을 간직한 감칠맛나고 시원한 육수 \n\n일반적인 메밀소바 식당보다 면이 더 많이 제공되고 면발이 쫄깃하다.\n\n1인 1메뉴 주문.\n\n식사 중 사리추가 불가합니다.");
        }
        if (name.contains("녹두빈대떡")){
            info2.setText("즉석에서 빻은 생녹두를 사용하여 기름지지 않고 고소하고 풍성한 맛\n\n일반적인 식용유를 사용하지 않고 고급 식용유 사용\n\n\n단품주문 불가!!");
        }
        if (name.contains("고사리")){
            info2.setText("카운터에서 주문 가능합니다.");
            add_menu.setVisibility(View.GONE);

        }
        if (name.contains("표고버섯")){
            info2.setText("카운터에서 주문 가능합니다.");
            add_menu.setVisibility(View.GONE);
        }
        if (name.contains("청계알")){
            info2.setText("자연에서 방사한 청계 유정란과 백봉오골계 유정란을 구워서 단백하고 찰진 맛의 계란\n\n\n카운터에서 주문 가능합니다.");
            add_menu.setVisibility(View.GONE);
        }






        eventText = RootView.findViewById(R.id.detailfragment_text_event);
        radio1 = RootView.findViewById(R.id.l_btn1);
        radio2 = RootView.findViewById(R.id.l_btn2);
        radio11 = RootView.findViewById(R.id.l_btn12);
        radio12 = RootView.findViewById(R.id.l_btn22);
        radio13 = RootView.findViewById(R.id.l_btn3);
        radio14 = RootView.findViewById(R.id.l_btn4);
        radio15 = RootView.findViewById(R.id.l_btn5);
        radio16 = RootView.findViewById(R.id.l_btn6);
        radio17 = RootView.findViewById(R.id.l_btn7);

        radio21 = RootView.findViewById(R.id.r_btn2);
        radio22 = RootView.findViewById(R.id.r_btn3);
        radio23 = RootView.findViewById(R.id.r_btn4);
        radio24 = RootView.findViewById(R.id.r_btn5);
        radio25 = RootView.findViewById(R.id.r_btn6);
        radio26 = RootView.findViewById(R.id.r_btn7);

        plusCheck.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (plusCheck.isChecked()){
                    price = String.valueOf(Integer.parseInt(dPrice)+ 3000);
                    DecimalFormat myFormatter = new DecimalFormat("###,###");
                    String formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                    priceText.setText("총 "+ formattedStringPrice+"원");
                }else{
                    price = String.valueOf(Integer.parseInt(dPrice));
                    DecimalFormat myFormatter = new DecimalFormat("###,###");
                    String formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                    priceText.setText("총 "+ formattedStringPrice+"원");
                }
            }
        });

        radioText = RootView.findViewById(R.id.radio_text);
        check_layout = RootView.findViewById(R.id.check_group);
//        nameTextsub = RootView.findViewById(R.id.detailfragment_text_name_sub);
        radiolayout2 = RootView.findViewById(R.id.radio_layout2);



        radioGroup = RootView.findViewById(R.id.radioGroup);
        radioGroup1 = RootView.findViewById(R.id.radioGroup0);
        radio = RootView.findViewById(R.id.radio_layout);
        if (name.equals("흑돼지콩나물불고기") || name.equals("낙지흑돼지콩나물불고기") || name.equals("김치흑돼지콩나물불고기") || name.contains("전골")){
            radio.setVisibility(View.VISIBLE);
        }
        int imenu = RootView.getResources().getIdentifier(url, "drawable", getContext().getPackageName());

        menuImg = RootView.findViewById(R.id.detailfragment_img);
        Glide.with(getContext()).load(imenu).into(menuImg);
//        GlideApp.with(getContext()).load(url).circleCrop().thumbnail(0.2f).into(menuImg);

        nameText = RootView.findViewById(R.id.detailfragment_text_name);
        nameText.setText(name);

        infoText = RootView.findViewById(R.id.detailfragment_text_info);
        infoText.setText(info);

        close = RootView.findViewById(R.id.detailfragment_layout_cancle);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MenuActivity)getActivity()).closeDetail(position);

            }
        });
        detailCount = RootView.findViewById(R.id.detail_count);

        if (name.equals("송이불고기") || name.equals("송이전골") || name.equals("불고기") || name.equals("송이돌솥정식") || name.equals("약수돌솥정식")
                || name.equals("송이황태해장국") || name.equals("송이칼국수")){
            detailCount.setText("2");
        }
        priceText = RootView.findViewById(R.id.detailfragment_text_price);
        DecimalFormat myFormatter = new DecimalFormat("###,###");
        String formattedStringPrice = myFormatter.format(Integer.parseInt(price)*Integer.parseInt(detailCount.getText().toString()));
        priceText.setText("총 "+formattedStringPrice+ "원");

        plus = RootView.findViewById(R.id.menu_plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(detailCount.getText().toString());
                count++;
                detailCount.setText(String.valueOf(count));
                price = String.valueOf(Integer.parseInt(dPrice)*Integer.parseInt(detailCount.getText().toString()));
                DecimalFormat myFormatter = new DecimalFormat("###,###");
                String formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                priceText.setText("총 "+ formattedStringPrice+"원");
            }
        });
        minus = RootView.findViewById(R.id.menu_minus);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(detailCount.getText().toString());
                if (name.equals("송이불고기") || name.equals("송이전골") || name.equals("불고기") || name.equals("송이돌솥정식") || name.equals("약수돌솥정식")
                        || name.equals("송이황태해장국") || name.equals("송이칼국수")){
                    if (count > 2) {
                        count--;
                        detailCount.setText(String.valueOf(count));
                        price = String.valueOf(Integer.parseInt(price) - Integer.parseInt(dPrice));
                        DecimalFormat myFormatter = new DecimalFormat("###,###");
                        String formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                        priceText.setText("총 " + formattedStringPrice + "원");
                    }
                }else {
                    if (count > 1) {
                        count--;
                        detailCount.setText(String.valueOf(count));
                        price = String.valueOf(Integer.parseInt(price) - Integer.parseInt(dPrice));
                        DecimalFormat myFormatter = new DecimalFormat("###,###");
                        String formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                        priceText.setText("총 " + formattedStringPrice + "원");
                    }
                }
            }
        });
        add_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (plusCheck.isChecked()){
                    name = name+"(사리추가)";
                }
                if (name.contains("흑돼지")){
                    if (radio1.isChecked()) {
                        name = name+("(보)");
                        Log.d("daon_test", "count = "+detailCount.getText().toString());
                        String d_price = String.valueOf(Integer.parseInt(dPrice)*Integer.parseInt(detailCount.getText().toString()));
                        for (int i = 0; i < Integer.parseInt(detailCount.getText().toString()); i++) {
                            ((MenuActivity) getActivity()).callItem(name, dPrice, url, code, "1");
                        }
                        sendOpt();
                        ((MenuActivity) getActivity()).closeDetail(position);
                    }else{
                        name = name+("(매)");
                        String d_price = String.valueOf(Integer.parseInt(dPrice)*Integer.parseInt(detailCount.getText().toString()));
                        for (int i = 0; i < Integer.parseInt(detailCount.getText().toString()); i++) {
                            ((MenuActivity) getActivity()).callItem(name, dPrice, url, code, "1");
                        }
                        sendOpt();
                        ((MenuActivity) getActivity()).closeDetail(position);
                    }
                }else {
                    if (name.equals("해바라기아줌마반반치킨") || name.equals("해바라기아줌마반반치킨(윙봉)") || name.equals("해바라기아줌마반반치킨(순살)")){
                        String submenu = "(";
                        if (radio11.isChecked()){
                            submenu = submenu + ("후라이드");
                        }else if (radio12.isChecked()){
                            submenu = submenu + ("양념");
                        }else if (radio13.isChecked()){
                            submenu = submenu + ("간장");
                        }else if (radio14.isChecked()){
                            submenu = submenu + ("레드핫");
                        }else if (radio15.isChecked()){
                            submenu = submenu + ("깐풍");
                        }else if (radio16.isChecked()){
                            submenu = submenu + ("치즈");
                        }else if (radio17.isChecked()){
                            submenu = submenu + ("갈비");
                        }

                        if (radio21.isChecked()){
                            submenu = submenu + ("+양념)");
                        }else if (radio22.isChecked()){
                            submenu = submenu + ("+간장)");
                        }else if (radio23.isChecked()){
                            submenu = submenu + ("+레드핫)");
                        }else if (radio24.isChecked()){
                            submenu = submenu + ("+깐풍)");
                        }else if (radio25.isChecked()){
                            submenu = submenu + ("+치즈)");
                        }else if (radio26.isChecked()){
                            submenu = submenu + ("+갈비)");
                        }

                        name = name + submenu;
                        ((MenuActivity) getActivity()).callItem(name, price, url, code,"1");
                        ((MenuActivity) getActivity()).closeDetail(position);
                    }else if (name.contains("한라산") || name.equals("참이슬") || name.equals("진로")) {
                        if (radio1.isChecked()) {
                            for (int i = 0; i < Integer.parseInt(detailCount.getText().toString()); i++) {
                                ((MenuActivity) getActivity()).callItem(name, dPrice, url, code, "1");
                            }
                            sendOpt();
                            ((MenuActivity) getActivity()).closeDetail(position);
                        }else{
                            for (int i = 0; i < Integer.parseInt(detailCount.getText().toString()); i++) {
                                ((MenuActivity) getActivity()).callItem(name, dPrice, url, code, "1");
                            }                            sendOpt();
                            ((MenuActivity) getActivity()).closeDetail(position);
                        }

                    }else {
                        if (plusCheck.isChecked()){
                            String d_price = String.valueOf(Integer.parseInt(dPrice)+3000);
                            for (int i = 0; i < Integer.parseInt(detailCount.getText().toString()); i++) {
                                ((MenuActivity) getActivity()).callItem(name, d_price, url, code, "1");
                            }
                            ((MenuActivity) getActivity()).closeDetail(position);
                        }else{
                            String d_price = String.valueOf(Integer.parseInt(dPrice));
                            for (int i = 0; i < Integer.parseInt(detailCount.getText().toString()); i++) {
                                ((MenuActivity) getActivity()).callItem(name, dPrice, url, code, "1");
                            }
                            ((MenuActivity) getActivity()).closeDetail(position);
                        }

                    }
                }


            }
        });
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("daon_test", "change = "+checkedId);
                if (checkedId != R.id.l_btn12){
                    price = String.valueOf(Integer.parseInt(dPrice)+ 1000);
                    DecimalFormat myFormatter = new DecimalFormat("###,###");
                    String formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                    priceText.setText("총 "+ formattedStringPrice+"원");

                }else{
                    price = String.valueOf(Integer.parseInt(dPrice));
                    DecimalFormat myFormatter = new DecimalFormat("###,###");
                    String formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                    priceText.setText("총 "+ formattedStringPrice+"원");
                }
            }
        });

        opt1 = RootView.findViewById(R.id.opt1);
        opt1.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (opt1.isChecked()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("공기밥 수량을 선택하세요.");
                    builder.setCancelable(false);
                    // add a list
                    String[] animals = {"0", "1", "2", "3", "4"};
                    builder.setItems(animals, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case 0:
                                    opt1.setChecked(false);
                                    str_opt1 = "0";
                                    break;
                                case 1:
                                    price = String.valueOf(Integer.parseInt(price) + 1000);
                                    DecimalFormat myFormatter = new DecimalFormat("###,###");
                                    String formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt1 = "1";
                                    opt1.setText("공기밥 "+str_opt1+"개");
                                    break;
                                case 2:
                                    price = String.valueOf(Integer.parseInt(price) + 2000);
                                    myFormatter = new DecimalFormat("###,###");
                                    formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt1 = "2";
                                    opt1.setText("공기밥 "+str_opt1+"개");
                                    break;
                                case 3:
                                    price = String.valueOf(Integer.parseInt(price) + 3000);
                                    myFormatter = new DecimalFormat("###,###");
                                    formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt1 = "3";
                                    opt1.setText("공기밥 "+str_opt1+"개");
                                    break;
                                case 4:
                                    price = String.valueOf(Integer.parseInt(price) + 4000);
                                    myFormatter = new DecimalFormat("###,###");
                                    formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt1 = "4";
                                    opt1.setText("공기밥 "+str_opt1+"개");
                                    break;
                            }
                        }
                    });
                    // create and show the alert dialog
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }else{
                    if (str_opt1 != null) {
                        price = String.valueOf(Integer.parseInt(price) - (1000 * Integer.parseInt(str_opt1)));
                        DecimalFormat myFormatter = new DecimalFormat("###,###");
                        String formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                        priceText.setText("총 " + formattedStringPrice + "원");
                        opt1.setText("공기밥 (+1,000원)");
                    }
                }
            }
        });

        opt2 = RootView.findViewById(R.id.opt2);
        opt2.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (opt2.isChecked()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("떡사리 수량을 선택하세요.");
                    builder.setCancelable(false);
                    // add a list
                    String[] animals = {"0", "1", "2", "3", "4"};
                    builder.setItems(animals, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case 0:
                                    opt2.setChecked(false);
                                    str_opt2 = "0";
                                    break;
                                case 1:
                                    price = String.valueOf(Integer.parseInt(price) + 1000);
                                    DecimalFormat myFormatter = new DecimalFormat("###,###");
                                    String formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt2 = "1";
                                    opt2.setText("떡사리 "+str_opt2+"개");
                                    break;
                                case 2:
                                    price = String.valueOf(Integer.parseInt(price) + 2000);
                                    myFormatter = new DecimalFormat("###,###");
                                    formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt2 = "2";
                                    opt2.setText("떡사리 "+str_opt2+"개");
                                    break;
                                case 3:
                                    price = String.valueOf(Integer.parseInt(price) + 3000);
                                    myFormatter = new DecimalFormat("###,###");
                                    formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt2 = "3";
                                    opt2.setText("떡사리 "+str_opt2+"개");
                                    break;
                                case 4:
                                    price = String.valueOf(Integer.parseInt(price) + 4000);
                                    myFormatter = new DecimalFormat("###,###");
                                    formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt2 = "4";
                                    opt2.setText("떡사리 "+str_opt2+"개");
                                    break;
                            }
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }else{
                    if (str_opt2 != null) {
                        price = String.valueOf(Integer.parseInt(price) - (1000 * Integer.parseInt(str_opt2)));
                        DecimalFormat myFormatter = new DecimalFormat("###,###");
                        String formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                        priceText.setText("총 " + formattedStringPrice + "원");
                        opt2.setText("떡사리 (+1,000원)");
                    }
                }
            }
        });

        opt3 = RootView.findViewById(R.id.opt3);
        opt3.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (opt3.isChecked()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("쫄면사리 수량을 선택하세요.");
                    builder.setCancelable(false);
                    // add a list
                    String[] animals = {"0", "1", "2", "3", "4"};
                    builder.setItems(animals, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case 0:
                                    opt3.setChecked(false);
                                    str_opt3 = "0";
                                    break;
                                case 1:
                                    price = String.valueOf(Integer.parseInt(price) + 2000);
                                    DecimalFormat myFormatter = new DecimalFormat("###,###");
                                    String formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt3 = "1";
                                    opt3.setText("쫄면사리 "+str_opt3+"개");
                                    break;
                                case 2:
                                    price = String.valueOf(Integer.parseInt(price) + 4000);
                                    myFormatter = new DecimalFormat("###,###");
                                    formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt3 = "2";
                                    opt3.setText("쫄면사리 "+str_opt3+"개");
                                    break;
                                case 3:
                                    price = String.valueOf(Integer.parseInt(price) + 6000);
                                    myFormatter = new DecimalFormat("###,###");
                                    formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt3 = "3";
                                    opt3.setText("쫄면사리 "+str_opt3+"개");
                                    break;
                                case 4:
                                    price = String.valueOf(Integer.parseInt(price) + 8000);
                                    myFormatter = new DecimalFormat("###,###");
                                    formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt3 = "4";
                                    opt3.setText("쫄면사리 "+str_opt3+"개");
                                    break;
                            }
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }else{
                    if (str_opt3 != null) {
                        price = String.valueOf(Integer.parseInt(price) - (2000 * Integer.parseInt(str_opt3)));
                        DecimalFormat myFormatter = new DecimalFormat("###,###");
                        String formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                        priceText.setText("총 " + formattedStringPrice + "원");
                        opt3.setText("쫄면사리 (+1,000원)");
                    }
                }
            }
        });

        opt4 = RootView.findViewById(R.id.opt4);
        opt4.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (opt4.isChecked()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("쫄면사리 수량을 선택하세요.");
                    builder.setCancelable(false);
                    // add a list
                    String[] animals = {"0", "1", "2", "3", "4"};
                    builder.setItems(animals, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case 0:
                                    opt4.setChecked(false);
                                    str_opt4 = "0";
                                    break;
                                case 1:
                                    price = String.valueOf(Integer.parseInt(price) + 2000);
                                    DecimalFormat myFormatter = new DecimalFormat("###,###");
                                    String formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt4 = "1";
                                    opt4.setText("우동사리 "+str_opt4+"개");
                                    break;
                                case 2:
                                    price = String.valueOf(Integer.parseInt(price) + 4000);
                                    myFormatter = new DecimalFormat("###,###");
                                    formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt4 = "2";
                                    opt4.setText("우동사리 "+str_opt4+"개");
                                    break;
                                case 3:
                                    price = String.valueOf(Integer.parseInt(price) + 6000);
                                    myFormatter = new DecimalFormat("###,###");
                                    formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt4 = "3";
                                    opt4.setText("우동사리 "+str_opt4+"개");
                                    break;
                                case 4:
                                    price = String.valueOf(Integer.parseInt(price) + 8000);
                                    myFormatter = new DecimalFormat("###,###");
                                    formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt4 = "4";
                                    opt4.setText("우동사리 "+str_opt4+"개");
                                    break;
                            }
                        }
                    });
                    // create and show the alert dialog
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }else{
                    if (str_opt4 != null) {
                        price = String.valueOf(Integer.parseInt(price) - (2000 * Integer.parseInt(str_opt4)));
                        DecimalFormat myFormatter = new DecimalFormat("###,###");
                        String formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                        priceText.setText("총 " + formattedStringPrice + "원");
                        opt4.setText("우동사리 (+2,000원)");
                    }
                }
            }
        });

        opt5 = RootView.findViewById(R.id.opt5);
        opt5.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (opt5.isChecked()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("비엔나사리 수량을 선택하세요.");
                    builder.setCancelable(false);
                    // add a list
                    String[] animals = {"0", "1", "2", "3", "4"};
                    builder.setItems(animals, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case 0:
                                    opt5.setChecked(false);
                                    str_opt5 = "0";
                                    break;
                                case 1:
                                    price = String.valueOf(Integer.parseInt(price) + 2000);
                                    DecimalFormat myFormatter = new DecimalFormat("###,###");
                                    String formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt5 = "1";
                                    opt5.setText("비엔나사리 "+str_opt5+"개");
                                    break;
                                case 2:
                                    price = String.valueOf(Integer.parseInt(price) + 4000);
                                    myFormatter = new DecimalFormat("###,###");
                                    formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt5 = "2";
                                    opt5.setText("비엔나사리 "+str_opt5+"개");
                                    break;
                                case 3:
                                    price = String.valueOf(Integer.parseInt(price) + 6000);
                                    myFormatter = new DecimalFormat("###,###");
                                    formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt5 = "3";
                                    opt5.setText("비엔나사리 "+str_opt5+"개");
                                    break;
                                case 4:
                                    price = String.valueOf(Integer.parseInt(price) + 8000);
                                    myFormatter = new DecimalFormat("###,###");
                                    formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt5 = "4";
                                    opt5.setText("비엔나사리 "+str_opt5+"개");
                                    break;
                                default:
                            }
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }else{
                    if (str_opt5 != null) {
                        price = String.valueOf(Integer.parseInt(price) - (2000 * Integer.parseInt(str_opt5)));
                        DecimalFormat myFormatter = new DecimalFormat("###,###");
                        String formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                        priceText.setText("총 " + formattedStringPrice + "원");
                        opt5.setText("비엔나사리 (+2,000원)");
                    }
                }
            }
        });

        opt6 = RootView.findViewById(R.id.opt6);
        opt6.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (opt6.isChecked()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("라면사리 수량을 선택하세요.");
                    builder.setCancelable(false);
                    String[] animals = {"0", "1", "2", "3", "4"};
                    builder.setItems(animals, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case 0:
                                    opt6.setChecked(false);
                                    str_opt6 = "0";
                                    break;
                                case 1:
                                    price = String.valueOf(Integer.parseInt(price) + 1000);
                                    DecimalFormat myFormatter = new DecimalFormat("###,###");
                                    String formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt6 = "1";
                                    opt6.setText("라면사리 "+str_opt6+"개");
                                    break;
                                case 2:
                                    price = String.valueOf(Integer.parseInt(price) + 2000);
                                    myFormatter = new DecimalFormat("###,###");
                                    formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt6 = "2";
                                    opt6.setText("라면사리 "+str_opt6+"개");
                                    break;
                                case 3:
                                    price = String.valueOf(Integer.parseInt(price) + 3000);
                                    myFormatter = new DecimalFormat("###,###");
                                    formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt6 = "3";
                                    opt6.setText("라면사리 "+str_opt6+"개");
                                    break;
                                case 4:
                                    price = String.valueOf(Integer.parseInt(price) + 4000);
                                    myFormatter = new DecimalFormat("###,###");
                                    formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt6 = "4";
                                    opt6.setText("라면사리 "+str_opt6+"개");
                                    break;
                            }
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }else{
                    if (str_opt6 != null) {
                        price = String.valueOf(Integer.parseInt(price) - (1000 * Integer.parseInt(str_opt6)));
                        DecimalFormat myFormatter = new DecimalFormat("###,###");
                        String formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                        priceText.setText("총 " + formattedStringPrice + "원");
                        opt6.setText("라면사리 (+1,000원)");
                    }
                }
            }
        });

        opt7 = RootView.findViewById(R.id.opt7);
        opt7.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (opt7.isChecked()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("감자당면 수량을 선택하세요.");
                    builder.setCancelable(false);
                    // add a list
                    String[] animals = {"0", "1", "2", "3", "4"};
                    builder.setItems(animals, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case 0:
                                    opt7.setChecked(false);
                                    str_opt7 = "0";
                                    break;
                                case 1:
                                    price = String.valueOf(Integer.parseInt(price) + 2000);
                                    DecimalFormat myFormatter = new DecimalFormat("###,###");
                                    String formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt7 = "1";
                                    opt7.setText("감자당면 "+str_opt7+"개");
                                    break;
                                case 2:
                                    price = String.valueOf(Integer.parseInt(price) + 4000);
                                    myFormatter = new DecimalFormat("###,###");
                                    formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt7 = "2";
                                    opt7.setText("감자당면 "+str_opt7+"개");
                                    break;
                                case 3:
                                    price = String.valueOf(Integer.parseInt(price) + 6000);
                                    myFormatter = new DecimalFormat("###,###");
                                    formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt7 = "3";
                                    opt7.setText("감자당면 "+str_opt7+"개");
                                    break;
                                case 4:
                                    price = String.valueOf(Integer.parseInt(price) + 8000);
                                    myFormatter = new DecimalFormat("###,###");
                                    formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt7 = "4";
                                    opt7.setText("비엔나사리 "+str_opt7+"개");
                                    break;
                            }
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }else{
                    if (str_opt7 != null) {
                        price = String.valueOf(Integer.parseInt(price) - (2000 * Integer.parseInt(str_opt7)));
                        DecimalFormat myFormatter = new DecimalFormat("###,###");
                        String formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                        priceText.setText("총 " + formattedStringPrice + "원");
                        opt7.setText("감자당면 (+2,000원)");
                    }
                }
            }
        });

        opt8 = RootView.findViewById(R.id.opt8);
        opt8.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (opt8.isChecked()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("콩나물추가 수량을 선택하세요.");
                    builder.setCancelable(false);
                    String[] animals = {"0", "1", "2", "3", "4"};
                    builder.setItems(animals, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case 0:
                                    opt8.setChecked(false);
                                    str_opt8 = "0";
                                    break;
                                case 1:
                                    price = String.valueOf(Integer.parseInt(price) + 1000);
                                    DecimalFormat myFormatter = new DecimalFormat("###,###");
                                    String formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt8 = "1";
                                    opt8.setText("콩나물추가 "+str_opt8+"개");
                                    break;
                                case 2:
                                    price = String.valueOf(Integer.parseInt(price) + 2000);
                                    myFormatter = new DecimalFormat("###,###");
                                    formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt8 = "2";
                                    opt8.setText("콩나물추가 "+str_opt8+"개");
                                    break;
                                case 3:
                                    price = String.valueOf(Integer.parseInt(price) + 3000);
                                    myFormatter = new DecimalFormat("###,###");
                                    formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt8 = "3";
                                    opt8.setText("콩나물추가 "+str_opt8+"개");
                                    break;
                                case 4:
                                    price = String.valueOf(Integer.parseInt(price) + 4000);
                                    myFormatter = new DecimalFormat("###,###");
                                    formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt8 = "4";
                                    opt8.setText("콩나물추가 "+str_opt8+"개");
                                    break;
                            }
                        }
                    });
                    // create and show the alert dialog
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }else{
                    if (str_opt8 != null) {
                        price = String.valueOf(Integer.parseInt(price) - (1000 * Integer.parseInt(str_opt8)));
                        DecimalFormat myFormatter = new DecimalFormat("###,###");
                        String formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                        priceText.setText("총 " + formattedStringPrice + "원");
                        opt8.setText("콩나물추가 (+1,000원)");
                    }
                }
            }
        });

        opt9 = RootView.findViewById(R.id.opt9);
        opt9.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (opt9.isChecked()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("숙주나물추가 수량을 선택하세요.");
                    builder.setCancelable(false);
                    String[] animals = {"0", "1", "2", "3", "4"};
                    builder.setItems(animals, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case 0:
                                    opt9.setChecked(false);
                                    str_opt9 = "0";
                                    break;
                                case 1:
                                    price = String.valueOf(Integer.parseInt(price) + 1000);
                                    DecimalFormat myFormatter = new DecimalFormat("###,###");
                                    String formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt9 = "1";
                                    opt9.setText("숙주나물추가 "+str_opt9+"개");
                                    break;
                                case 2:
                                    price = String.valueOf(Integer.parseInt(price) + 2000);
                                    myFormatter = new DecimalFormat("###,###");
                                    formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt9 = "2";
                                    opt8.setText("숙주나물추가 "+str_opt9+"개");
                                    break;
                                case 3:
                                    price = String.valueOf(Integer.parseInt(price) + 3000);
                                    myFormatter = new DecimalFormat("###,###");
                                    formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt9 = "3";
                                    opt9.setText("숙주나물추가 "+str_opt9+"개");
                                    break;
                                case 4:
                                    price = String.valueOf(Integer.parseInt(price) + 4000);
                                    myFormatter = new DecimalFormat("###,###");
                                    formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                                    priceText.setText("총 "+formattedStringPrice+ "원");
                                    str_opt9 = "4";
                                    opt9.setText("숙주나물추가 "+str_opt9+"개");
                                    break;
                            }
                        }
                    });
                    // create and show the alert dialog
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }else{
                    if (str_opt9 != null) {
                        price = String.valueOf(Integer.parseInt(price) - (1000 * Integer.parseInt(str_opt9)));
                        DecimalFormat myFormatter = new DecimalFormat("###,###");
                        String formattedStringPrice = myFormatter.format(Integer.parseInt(price));
                        priceText.setText("총 " + formattedStringPrice + "원");
                        opt9.setText("숙주나물추가 (+1,000원)");
                    }
                }
            }
        });
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("HH",  Locale.getDefault());
        int time = Integer.parseInt(format.format(calendar.getTime()));
        if (time < 14){
            opt1.setVisibility(View.GONE);
            if (name.contains("흑돼지")){
                eventText.setVisibility(View.VISIBLE);
            }
        }else{

        }
        if (name.contains("숙주")){
            opt8.setVisibility(View.GONE);
        }
        if (name.contains("콩나물")){
            opt9.setVisibility(View.GONE);
        }
    }

    public void sendOpt(){
        if (opt1.isChecked()){
            String price = String.valueOf(Integer.parseInt(str_opt1)* 1000);
            for (int i = 0; i < Integer.parseInt(str_opt1); i++) {
                ((MenuActivity) getActivity()).callItem("공기밥", "1000", url, code, "1");
            }
        }
        if (opt2.isChecked()){
            String price = String.valueOf(Integer.parseInt(str_opt2)* 1000);
            for (int i = 0; i < Integer.parseInt(str_opt2); i++) {

                ((MenuActivity) getActivity()).callItem("떡사리", "1000", url, code, "1");
            }
        }
        if (opt3.isChecked()){
            String price = String.valueOf(Integer.parseInt(str_opt3)* 2000);
            for (int i = 0; i < Integer.parseInt(str_opt3); i++) {

                ((MenuActivity) getActivity()).callItem("쫄면사리", "2000", url, code, "1");
            }
        }
        if (opt4.isChecked()){
            String price = String.valueOf(Integer.parseInt(str_opt4)* 2000);
            for (int i = 0; i < Integer.parseInt(str_opt4); i++) {

                ((MenuActivity) getActivity()).callItem("우동사리", "2000", url, code, "1");
            }
        }
        if (opt5.isChecked()){
            String price = String.valueOf(Integer.parseInt(str_opt5)* 2000);
            for (int i = 0; i < Integer.parseInt(str_opt5); i++) {

                ((MenuActivity) getActivity()).callItem("비엔나사리", "2000", url, code, "1");
            }
        }
        if (opt6.isChecked()){
            String price = String.valueOf(Integer.parseInt(str_opt6)* 1000);

            for (int i = 0; i < Integer.parseInt(str_opt6); i++) {
                ((MenuActivity) getActivity()).callItem("라면사리", "1000", url, code, "1");
            }
        }
        if (opt7.isChecked()){
            String price = String.valueOf(Integer.parseInt(str_opt7)* 2000);
            for (int i = 0; i < Integer.parseInt(str_opt7); i++) {

                ((MenuActivity) getActivity()).callItem("감자당면", "2000", url, code, "1");
            }
        }
        if (opt8.isChecked()){
            String price = String.valueOf(Integer.parseInt(str_opt8)* 1000);
            for (int i = 0; i < Integer.parseInt(str_opt8); i++) {

                ((MenuActivity) getActivity()).callItem("콩나물추가", "1000", url, code, "1");
            }
        }
        if (opt9.isChecked()){
            String price = String.valueOf(Integer.parseInt(str_opt9)* 1000);
            for (int i = 0; i < Integer.parseInt(str_opt9); i++) {

                ((MenuActivity) getActivity()).callItem("숙주나물추가", "1000", url, code, "1");
            }
        }
    }
}