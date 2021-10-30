package com.example.schema;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Data implements LoaderManager.LoaderCallbacks<List<ChildItem>> {
    private static final String TAG ="error" ;
    private static final String USGS_REQUEST_URL = "https://schema-eight.vercel.app/api/allyojna";
    List<ChildItem> alList=new ArrayList<ChildItem>();
    List<ChildItem> pm=new ArrayList<ChildItem>();
    List<ChildItem> kissan=new ArrayList<ChildItem>();
    List<ChildItem> employment=new ArrayList<ChildItem>();
    List<ChildItem> students=new ArrayList<ChildItem>();
    List<ChildItem> women=new ArrayList<ChildItem>();

    @NonNull
//    @org.jetbrains.annotations.NotNull
    @Override
    public Loader<List<ChildItem>> onCreateLoader(int id, Bundle args) {
        return new SchemeLoader(Data.this,USGS_REQUEST_URL);
    }

    @Override
    public void onLoadFinished( Loader<List<ChildItem>> loader, List<ChildItem> data) {

    }

    @Override
    public void onLoaderReset(Loader<List<ChildItem>> loader) {

    }

    public List<ChildItem> getWomen() {
        return women;
    }

    public List<ChildItem> getEmployment() {
        return employment;
    }

    public List<ChildItem> getKissan() {
        return kissan;
    }

    public List<ChildItem> getPm() {
        return pm;
    }

    public List<ChildItem> getStudents() {
        return students;
    }



    public Data(){
        String about="Persons who do not have any other accounts can open a basic savings bank deposit (BSBD) account in any bank branch or Business Correspondent (Bank Mitra) outlet under the scheme.\n" +
                "\n" +
                "On August 28, 2014, Narendra Modi announced the Pradhan Mantri Jan-Dhan Yojana (PMJDY). It is a national mission with the goal of providing affordable access to various financial services such as remittance, credit, insurance, pension, banking savings, and deposit accounts\n" +
                "\n";
        String application="Website\n" +
                "https://www.pmjdy.gov.in/ \n\n" +
                "Eligibility\n\n" +
                "Anyone who wants to open a basic bank account.\n" +
                "\nDocument required\n" +
                "Additional documents are not required if an Aadhaar card or Aadhaar number is provided. If the address has changed, a self-certified report is all that is required.\n" +
                "If you do not have an Aadhaar card, you must provide one of the following legal documents: Voter ID, Driver's License, Passport, PAN Card, and NREGA card are all acceptable forms of identification.";
        String information=about+"PMJDY Benefits\n" +
                "\n" +
                "1. One basic savings bank account is opened for each unbanked person.\n" +
                "2. There is no requirement to keep a minimum balance in PMJDY accounts.\n" +
                "3. Deposits in PMJDY accounts earn interest.\n" +
                "4. PMJDY account holders are given a Rupay Debit card.\n" +
                "5. Accident Insurance Coverage of Rs.1 lakh (enhanced to Rs.2 lakh for new PMJDY accounts opened after 28.8.2018) is available with the RuPay card issued to PMJDY account holders.\n" +
                "6. An overdraft ";
        this.alList.add(new ChildItem(" PMJDY",R.drawable.pjdy,information,application));
        this.pm.add(new ChildItem(" PMJDY",R.drawable.pjdy,information,application));
        String info2="The Pradhan Mantri Awas Yojana (PMAY) is an initiative of the Government of India which aims at providing affordable housing to the urban poor by the year 2022. The scheme was first launched on 1 June 2015. The interest rate for the PMAY scheme starts at 6.50% p.a. and can be availed for a tenure of up to 20 years+\n" +
                "PMAY Benefits\n" +
                "As mentioned previously, the primary goal of Pradhan Mantri Awas Yojana 2021 is to provide housing for all by 2022. Apart from this overall objective, listed below are some other features that the scheme brings along for its beneficiaries.\n" +
                "\n" +
                "Pradhan mantri awas yojna looks to offer affordable housing to individuals and families belonging to the economically challenged section of society. It prioritises housing for women, as well as minorities, including those belonging to the Scheduled Castes and Scheduled Tribes.\n" +
                "Senior citizens can take advantage of the scheme with the government favouring their claims when it comes to ground floor properties.\n" +
                "To avail the benefits from this scheme, interested individuals need to register for it. Further, it is mandatory for women, primarily mothers or wives, to be named the beneficiary.\n" +
                "Other minorities are also preferred under PM Awas yojana, including the transgender community, widows and members belonging to the lower-income group.\n" +
                "\n" ;

        String app2="Website\n"+"pmaymis.gov.in\n"+"Eligibility-\n" +
                "Before applying to the scheme, however, one must consider whether he/she is eligible to receive subsidies. The following factors determine eligibility for PM Awas yojna.\n" +
                "\n" +
                "Depending on a person’s income range, he/she would fall in EWS, LIG or MIG categories. However, if the family’s annual income exceeds the income range for the MIG group, which is Rs. 18 Lakh per year, they would be ineligible to avail benefits under the Pradhan Mantri Awas Yojana.\n" +
                "A woman’s name should be on the deed or the property papers. It can either be a sole proprietorship, where the woman owns the house, or it can be joint ownership, where one of the owners must be female to avail the scheme. Only when there are no females in a family can this rule be surpassed.\n" +
                "PMAY is only available for the new property purchase. Also, an applicant must not possess any other pucca properties when applying for the said credit-linked scheme.\n" +
                "The beneficiaries must not have availed any central assistance or benefits from any other housing scheme beforehand, from either the state or the central government for the scheme to apply.\n" +
                "The house or property for purchase must belong to one of the areas, towns, villages or cities as per the Census 2011.\n" +
                "Beneficiaries must not have availed benefits under pradhan mantri awasyojana or any other credit-linked subsidy scheme from any of the financial institutions beforehand.\n" +
                "If the primary reason for availing a home loan is the renovation or extension of an already existing property, the said work must be completed within 36 months from receiving the first loan instalment.\n" +
                "\n" +
                "Documents required\n" +
                "1. Application form\n" +
                "2. Proof of identity\n" +
                "3. Proof of address \n" +
                "4. Proof of income \n" +
                "5. Property documents \n";
        this.alList.add(new ChildItem("PMAY",R.drawable.pmay,info2,app2));
        this.pm.add(new ChildItem("PMAY",R.drawable.pmay,info2,app2));
        String ki=
                "Any Indian resident can take advantage of the Kisan Vikas Patra's benefits. However, Hindu Undivided Families (HUFs) and Non-Resident Indians (NRIs) are not eligible to invest in the Kisan Vikas Patra. This scheme was originally designed for farmers to help them save for the long term, but it is now available to any Indian resident.\n" +
                "\n" +
                "KVP Benifits:\n" +
                "1.The scheme allows for flexible denominations ranging from Rs.100 to a maximum of Rs.50,000.\n" +
                "2.Kisan Vikas Patra is a government scheme, so investors receive guaranteed returns.\n" +
                "3.KVP is a risk-free investment that pays the same interest rate all year.\n" +
                "4.The scheme has no upper limit on the amount of money that can be invested.\n" +
                "5.KVP allows for early withdrawal with a two-year and six-month lock-in period.\n" +
                "6.Kisan Vikas Patra can be transferred to anyone who qualifies. Before receiving the benefits, the new holder must submit all required documents and obtain approval from the post office.\n" +
                "7.There is no TDS on funds withdrawn from KVP after the maturity date has passed.\n" +
                "8.The scheme's current interest rate is 7.7 percent for the first quarter of fiscal year 2019-20.\n" +
                "\n";


        String ka=    "website- https://www.indiapost.gov.in/Financial/Pages/Content/Post-Office-Saving-Schemes.aspx\n" +
                "Eligibility:\n" +
                "\n" +
                "1.An adult acting in his or her own name or on behalf of a minor.\n" +
                "2.Three adults working together\n" +
                "\n" +
                "documents required\n" +
                "1.To be eligible for Kisan Vikas Patra, applicants must also supply the following documents in addition to being an Indian resident:\n" +
                "\n" +
                "\n" +
                "2.To avoid money laundering, the government of India made PAN Card evidence mandatory for all investments over Rs. 50,000 during the scheme's relaunch.\n" +
                "\n" +
                "3.To deposit Rs.10 lakhs or more, you must provide proof of income in the form of wage slips, bank statements, or ITR documents.\n" +
                "\n" +
                "4.PAN Card, Aadhaar Card, Voter's ID, Driver's License, or Passport photocopy";
        this.kissan.add(new ChildItem("KVP",R.drawable.kvp,ki,ka));
        this.alList.add(new ChildItem("KVP",R.drawable.kvp,ki,ka));

//        Log.d(TAG, "Data: "+"PMJDY"+R.drawable.pjdy+information+application);

    }


    public List<ChildItem> getAlList() {
return alList;
    }
}
