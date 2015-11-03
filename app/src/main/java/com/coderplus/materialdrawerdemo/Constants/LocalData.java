package com.coderplus.materialdrawerdemo.Constants;

import com.coderplus.materialdrawerdemo.R;
import com.coderplus.materialdrawerdemo.model.CoderTypeModel;
import com.coderplus.materialdrawerdemo.model.DatingModel;
import com.coderplus.materialdrawerdemo.model.ResumeModel;

import java.util.ArrayList;

/**
 * Created by xiejianchao on 15/10/16.
 */
public class LocalData {

    public static final int CODER_TYPE_ANDROID = 1;
    public static final int CODER_TYPE_IOS = 2;
    public static final int CODER_TYPE_JAVA = 3;

    public static ArrayList<CoderTypeModel> getCoderTypes() {
        ArrayList<CoderTypeModel> coderTypes = new ArrayList<CoderTypeModel>();
        //Android
        CoderTypeModel type1 = new CoderTypeModel();
        type1.setCoverResId(R.drawable.android_16_9);
        type1.setName("Android");
        type1.setType(CODER_TYPE_ANDROID);

        //iOS
        CoderTypeModel type2 = new CoderTypeModel();
        type2.setCoverResId(R.drawable.ios_16_9);
        type2.setName("iOS");
        type2.setType(CODER_TYPE_IOS);

        //Java
        CoderTypeModel type3 = new CoderTypeModel();
        type3.setCoverResId(R.drawable.java_16_9);
        type3.setName("Java");
        type3.setType(CODER_TYPE_JAVA);

        coderTypes.add(type1);
        coderTypes.add(type2);
        coderTypes.add(type3);
        return coderTypes;
    }

    public static ArrayList<DatingModel> getDatingData() {
        ArrayList<DatingModel> coderTypes = new ArrayList<DatingModel>();
        //Android
        DatingModel type1 = new DatingModel();
        type1.setCoverResId(R.drawable.s1);
        type1.setTitle("中国银行客服中心联谊活动");

        //iOS
        DatingModel type2 = new DatingModel();
        type2.setCoverResId(R.drawable.s2);
        type2.setTitle("南方航空公司北京分公司联谊");

        //Java
        DatingModel type3 = new DatingModel();
        type3.setCoverResId(R.drawable.s3);
        type3.setTitle("滴滴北京人事部大量妹子放松");

        DatingModel type4 = new DatingModel();
        type4.setCoverResId(R.drawable.s4);
        type4.setTitle("网易编辑部新毕业姑娘打折处理");

        DatingModel type5 = new DatingModel();
        type5.setCoverResId(R.drawable.s5);
        type5.setTitle("清华大学大四学生牵手程序员");

        coderTypes.add(type1);
        coderTypes.add(type2);
        coderTypes.add(type3);
        coderTypes.add(type4);
        coderTypes.add(type5);
        return coderTypes;
    }


    public static ArrayList<ResumeModel> getResumeList() {
        ArrayList<ResumeModel> list = new ArrayList<ResumeModel>();

        ResumeModel baseModel = new ResumeModel();
        //基本信息
        baseModel.setTitle("基本信息");
        ArrayList<String> baseList = new ArrayList<String>();
        baseList.add("学历：本科");
        baseList.add("工作年限：5年");
        baseList.add("年龄：27");
        baseModel.setDetails(baseList);
        list.add(baseModel);

        ResumeModel eduModel = new ResumeModel();
        eduModel.setTitle("教育经历");
        ArrayList eduList = new <String>ArrayList();
        eduList.add("2009年毕业");
        eduList.add("北京大学");
        eduList.add("计算机科学与技术");
        eduModel.setDetails(eduList);
        list.add(eduModel);

        ResumeModel workModel = new ResumeModel();
        workModel.setTitle("工作经历");
        ArrayList<String> workList = new ArrayList<String>();
        workList.add("阿里云计算中心");
        workList.add("研发总监");
        workList.add("制定产品研发方向，核心架构设计与核心代码编写，团队建设，团队技术培训，性能优化，稳定性测试方案设计。");
        workModel.setDetails(workList);
        list.add(workModel);

        return list;
    }

}
