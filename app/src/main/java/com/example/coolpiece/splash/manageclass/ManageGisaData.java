package com.example.coolpiece.splash.manageclass;

import com.example.coolpiece.splash.dataclass.Gisa;
import com.example.coolpiece.splash.dataclass.Gisul;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManageGisaData {
    private static ManageGisaData manageGisaData;
    Gisa gisa;
    private ArrayList<Gisa> gisaArrayList;
    private ArrayList<ArrayList<Gisa>> gisa_total;
    private ArrayList<String> gisalist;
    List<String> category= Arrays.asList("건설", "경영,회계,사무", "광업자원", "기계", "농림어업",
            "문화,예술,디자인,방송", "보건,의료", "사회복지,종교", "섬유,의복", "식품,가공", "안전관리", "영업,판매",
            "운전,운송", "음식서비스", "이용,숙박,여행,오락,스포츠", "인쇄,목재,가구,공예", "재료", "전기,전자", "정보통신",
            "화학", "환경,에너지");
    public static ManageGisaData getInstance(){
        if(manageGisaData==null){
            manageGisaData=new ManageGisaData();
        }
        return manageGisaData;
    }
    ManageGisaData(){
        gisa=new Gisa();
        gisaArrayList=new ArrayList<>(20);
        gisa_total=new ArrayList<>(20);
        gisalist=new ArrayList<>();
    }
    public ArrayList<ArrayList<Gisa>> getGisa_total(){return gisa_total;}

    public ArrayList<Gisa> getGisaArrayList(int position){
        return gisa_total.get(position);
    }
    public void startParsing(String json) throws JSONException {
        JSONObject jsonObject=new JSONObject(json);
        //for each category
        for(int i=0; i<category.size(); i++){
            JSONArray jsonArray=jsonObject.getJSONArray(category.get(i));
            for(int j=0; j<jsonArray.length()-1; j++){
                JSONObject temp=jsonArray.getJSONObject(j);
                gisa=new Gisa();
                gisa.setName(temp.get("name").toString());
                gisalist.add(temp.get("name").toString());
                gisa.setIntro(temp.get("intro(개요)").toString());
                gisa.setAssociation(temp.get("association(실시기관)").toString());
                gisa.setMajor(temp.get("major(관련학과)").toString());
                gisa.setTraining_center(temp.get("training_center(훈련기관)").toString());
                gisa.setTest_subject(temp.get("test_subject(시험과목)").toString());
                gisa.setTest_method(temp.get("test_method(검정방법)").toString());
                gisa.setCut_line(temp.get("cut_line(합격기준)").toString());
                /*JSONArray cal=temp.getJSONArray("calender(일정)");
                ArrayList<String> pilgi_apply=new ArrayList<>();
                ArrayList<String> pilgi_test=new ArrayList<>();
                ArrayList<String> pilgi_balpyo=new ArrayList<>();
                ArrayList<String> pilgi_balpyo_final=new ArrayList<>();
                ArrayList<String> silgi_apply=new ArrayList<>();
                ArrayList<String> silgi_test=new ArrayList<>();
                ArrayList<String> final_balpyo=new ArrayList<>();
                for(int a=0; a<cal.length(); a++){//calander list in jsonArray
                    JSONObject temp2=cal.getJSONObject(a);
                    pilgi_apply.add(temp2.get("pilgi_apply(필기 원서접수)").toString());
                    pilgi_test.add(temp2.get("pilgi_test(필기시험)").toString());
                    pilgi_balpyo.add(temp2.get("pilgi_balpyo(필기시험합격예정자 발표)").toString());
                    pilgi_balpyo_final.add(temp2.get("pilgi_balpyo(응시자격서류제출/필기시험합격자결정)").toString());
                    silgi_apply.add(temp2.get("silgi_apply(면접시험원서접수(인터넷))").toString());
                    silgi_test.add(temp2.get("silgi_test(면접시험)").toString());
                    final_balpyo.add(temp2.get("final_balpyo(합격자발표)").toString());
                }
                gisa.setPilgi_apply(pilgi_apply);
                gisa.setPilgi_test(pilgi_test);
                gisa.setPilgi_balpyo(pilgi_balpyo);
                gisa.setPilgi_balpyo_final(pilgi_balpyo_final);
                gisa.setSilgi_apply(silgi_apply);
                gisa.setSilgi_test(silgi_test);
                gisa.setFinal_balpyo(final_balpyo);
                JSONArray aca=temp.getJSONArray("academy(학원)");
                ArrayList<String> academy_name=new ArrayList<>();
                ArrayList<String> academy_address=new ArrayList<>();
                ArrayList<String> academy_phone=new ArrayList<>();
                ArrayList<String> academy_connect=new ArrayList<>();
                for(int a=0; a<aca.length(); a++){
                    JSONObject temp3=aca.getJSONObject(a);
                    academy_name.add(temp3.get("name").toString());
                    academy_phone.add(temp3.get("phone").toString());
                    academy_address.add(temp3.get("location").toString());
                    //academy_connect.add(temp3.get("jaehyu").toString());
                    academy_connect.add("no");
                }
                gisa.setAcademy_name(academy_name);
                gisa.setAcademy_address(academy_address);
                gisa.setAcademy_phone(academy_phone);
                gisa.setAcademy_connect(academy_connect);*/
                //when setting one certification, then add to gisulArrayList
                gisaArrayList.add(gisa);
                gisa=new Gisa();
            }//end of one category
            gisa_total.add(gisaArrayList);
            gisaArrayList=new ArrayList<>(20);
        }
    }
    public ArrayList<String> getGisalist(){
        return gisalist;
    }
}
