package com.villezone.gautam.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.villezone.gautam.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FAQOnlyFragment extends Fragment {

    public FAQOnlyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)  {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_f_a_q_only, container, false);

        WebView webview = view.findViewById(R.id.webView);

        String data = "\n" +
                "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n" +
                "<HTML>\n" +
                "<HEAD>\n" +
                "\t<META HTTP-EQUIV=\"CONTENT-TYPE\" CONTENT=\"text/html; charset=utf-8\">\n" +
                "\t<TITLE></TITLE>\n" +
                "\t<META NAME=\"GENERATOR\" CONTENT=\"LibreOffice 4.1.6.2 (Linux)\">\n" +
                "\t<META NAME=\"AUTHOR\" CONTENT=\"Prakash Nagotha\">\n" +
                "\t<META NAME=\"CREATED\" CONTENT=\"20200712;101700000000000\">\n" +
                "\t<META NAME=\"CHANGEDBY\" CONTENT=\"Prakash Nagotha\">\n" +
                "\t<META NAME=\"CHANGED\" CONTENT=\"20200712;130600000000000\">\n" +
                "\t<META NAME=\"AppVersion\" CONTENT=\"16.0000\">\n" +
                "\t<META NAME=\"DocSecurity\" CONTENT=\"0\">\n" +
                "\t<META NAME=\"HyperlinksChanged\" CONTENT=\"false\">\n" +
                "\t<META NAME=\"LinksUpToDate\" CONTENT=\"false\">\n" +
                "\t<META NAME=\"ScaleCrop\" CONTENT=\"false\">\n" +
                "\t<META NAME=\"ShareDoc\" CONTENT=\"false\">\n" +
                "\t<STYLE TYPE=\"text/css\">\n" +
                "\t<!--\n" +
                "\t\t@page { margin-left: 0.38in; margin-right: 0.39in; margin-top: 0.44in; margin-bottom: 0.31in }\n" +
                "\t\tP { margin-bottom: 0.08in; direction: ltr; widows: 2; orphans: 2 }\n" +
                "\t\tA:link { color: #0000ff; so-language: zxx }\n" +
                "\t-->\n" +
                "\t</STYLE>\n" +
                "</HEAD>\n" +
                "<BODY LANG=\"en-IN\" LINK=\"#0000ff\" DIR=\"LTR\">\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"Times New Roman, serif\"><FONT SIZE=4 STYLE=\"font-size: 13pt\">FAQ</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#666666\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">Kindly\n" +
                "check the FAQ below if you are not very familiar with the functioning\n" +
                "of this website. If your query is of urgent nature and is different\n" +
                "from the set of questions then do write to us at\n" +
                "support@villezone.com or call us on 91 04 91 01 91 between 10 am &amp;\n" +
                "6 pm on all days including Sunday to get our immediate help.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#656565\">&nbsp;</FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">Registration</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>How\n" +
                "do I register?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">You\n" +
                "can register by clicking on the &quot;Sign up&quot; link at the top\n" +
                "right corner of the homepage. Please provide the information in the\n" +
                "form that appears. You can review the terms and conditions, provide\n" +
                "your payment mode details and submit the registration information.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>Are\n" +
                "there any charges for registration?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">No.\n" +
                "Registration on villezone.com is absolutely free.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>Do\n" +
                "I have to necessarily register to shop on Villezone ?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">You\n" +
                "can surf and add products to the cart without registration but only\n" +
                "registered customer will be able to checkout and place orders.\n" +
                "Registered members have to be logged in at the time of checking out\n" +
                "the cart, they will be prompted to do so if they are not logged in.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>Can\n" +
                "I have multiple registrations?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">Each\n" +
                "email address and contact phone number can only be associated with\n" +
                "one villezone account.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>Can\n" +
                "I add more than one delivery address in an account?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">Yes,\n" +
                "you can add multiple delivery addresses in your villezone account.\n" +
                "However, remember that all items placed in a single order can only be\n" +
                "delivered to one address. If you want different products delivered to\n" +
                "different address you need to place them as separate orders.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>Can\n" +
                "I have multiple accounts with same mobile number and email id?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">Each\n" +
                "email address and phone number can be associated with one Villezone\n" +
                "account only.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>Can\n" +
                "I have multiple accounts for members in my family with different\n" +
                "mobile number and email address but same or common delivery address?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">Yes,\n" +
                "we do understand the importance of time and the toil involved in\n" +
                "shopping groceries. Up to three members in a family can have the same\n" +
                "address provided the email address and phone number associated with\n" +
                "the accounts are unique.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>Can\n" +
                "I have different city addresses under one account and still place\n" +
                "orders for multiple cities?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">Yes,\n" +
                "you can place orders for multiple cities.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">Account\n" +
                "Related</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>What\n" +
                "is My Account?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">My\n" +
                "Account is the section you reach after you log in at villezone.com.\n" +
                "My Account allows you to track your active orders, credit note\n" +
                "details as well as see your order history and update your contact\n" +
                "details.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>How\n" +
                "do I reset my password?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">You\n" +
                "need to enter your email address on the Login page and click on\n" +
                "forgot password. An email with a reset password will be sent to your\n" +
                "email address. With this, you can change your password. In case of\n" +
                "any further issues please contact our customer support team.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>What\n" +
                "are credit notes &amp; where can I see my credit notes?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">Credit\n" +
                "notes reflect the amount of money which you have pending in your\n" +
                "villezone account to use against future purchases. This is calculated\n" +
                "by deducting your total order value minus undelivered value. You can\n" +
                "see this in &quot;My Account&quot; under credit note details.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>What\n" +
                "is My Shopping List?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">My\n" +
                "Shopping List is a comprehensive list of all the items previously\n" +
                "ordered by you on villezone.com. This enables you to shop quickly and\n" +
                "easily in future.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">Payment</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>What\n" +
                "are the modes of payment?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">You\n" +
                "can pay for your order on villezone.com using the following modes of\n" +
                "payment. Cash on delivery. Credit and debit cards (VISA / Mastercard\n" +
                "/ Rupay ).</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>Are\n" +
                "there any other charges or taxes in addition to the price shown? Is\n" +
                "VAT added to the invoice?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">There\n" +
                "is no VAT. However, GST will be applicable as per Government\n" +
                "Regulizations.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>Is\n" +
                "it safe to use my credit/ debit card on villezone?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">Yes\n" +
                "it is absolutely safe to use your card on villezone.com. A recent\n" +
                "directive from RBI makes it mandatory to have an additional\n" +
                "authentication pass code verified by VISA (VBV) or MSC (Master Secure\n" +
                "Code) which has to be entered by online shoppers while paying online\n" +
                "using visa or master credit card. It means extra security for\n" +
                "customers, thus making online shopping safer</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>What\n" +
                "is the meaning of cash on delivery?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">Cash\n" +
                "on delivery means that you can pay for your order at the time of\n" +
                "order delivery at your doorstep.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>If\n" +
                "I pay by credit card how do I get the amount back for items not\n" +
                "delivered?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">If\n" +
                "we are not able to delivery all the products in your order and you\n" +
                "have already paid for them online, the balance amount will be\n" +
                "refunded to your villezone account as store credit and you can use it\n" +
                "at any time against your future orders. Should you want it to be\n" +
                "credited to your bank account please contact our customer support\n" +
                "team and we will refund it back on to your card.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>Where\n" +
                "do I enter the coupon code?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">Once\n" +
                "you are done selecting your products and click on checkout you will\n" +
                "be prompted to select delivery slot and payment method. On the\n" +
                "payment method page there is a box where you can enter any evoucher/\n" +
                "coupon code that you have. The amount will automatically be deducted\n" +
                "from your invoice value.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>What\n" +
                "is villezone Wallet?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">The\n" +
                "villezone Wallet is a pre-paid credit account that is associated with\n" +
                "your villezone account. This prepaid account allows you to pay a lump\n" +
                "sum amount once to villezone and then shop multiple times without\n" +
                "having to pay each time. ( We haven’t wallet right now, but this\n" +
                "information used to you in future ).</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">Delivery\n" +
                "Related</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>When\n" +
                "will I receive my order?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">Once\n" +
                "you are done selecting your products and click on checkout you will\n" +
                "be prompted to select delivery slot. Your order will be delivered to\n" +
                "you on the day and slot selected by you. If we are unable to deliver\n" +
                "the order during the specified time duration (this sometimes happens\n" +
                "due to unforeseen situations).</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>How\n" +
                "are the fruits and vegetables packaged?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">Fresh\n" +
                "fruits and vegetables are hand picked, hand cleaned and hand packed\n" +
                "in reusable plastic trays covered with cling. We ensure hygienic and\n" +
                "careful handling of all our products.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>How\n" +
                "are the fruits and vegetables weighed?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">Every\n" +
                "fruit and vegetable varies a little in size and weight. While you\n" +
                "shop we show an estimated weight and price for everything priced by\n" +
                "kilogram. At the time of delivery we weigh each item to determine\n" +
                "final price. This could vary by 10% at maximum. Therefore if you have\n" +
                "shopped for something that costs Rs. 100 per kg, and we delivery 1.5\n" +
                "kg of the product to you (eg cabbage, pineapple), you will still be\n" +
                "charged a maximum of Rs. 110. In case the weight of the product is\n" +
                "lesser than what you ordered, you will pay correspondingly less.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>How\n" +
                "will the delivery be done?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">We\n" +
                "have a dedicated team of delivery personnel and a fleet of vehicles\n" +
                "operating across the city which ensures timely and accurate delivery\n" +
                "to our customers.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>How\n" +
                "do I change the delivery info (address to which I want products\n" +
                "delivered)?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">You\n" +
                "can change your delivery address on our website once you log into\n" +
                "your account. Click on &quot;My Account&quot; at the top right hand\n" +
                "corner and go to the &quot;Update My Profile&quot; section to change\n" +
                "your delivery address.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>How\n" +
                "much are the delivery charges?</FONT></FONT></FONT></P>\n" +
                "<CENTER>\n" +
                "\t<TABLE WIDTH=580 CELLPADDING=3 CELLSPACING=0>\n" +
                "\t\t<COL WIDTH=137>\n" +
                "\t\t<COL WIDTH=126>\n" +
                "\t\t<COL WIDTH=143>\n" +
                "\t\t<COL WIDTH=148>\n" +
                "\t\t<TR VALIGN=BOTTOM>\n" +
                "\t\t\t<TD WIDTH=137 BGCOLOR=\"#55a755\" STYLE=\"border: 1px solid #55a755; padding: 0.08in 0in\">\n" +
                "\t\t\t\t<P ALIGN=CENTER><FONT COLOR=\"#ffffff\"><FONT FACE=\"Helvetica, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\"><B>City</B></FONT></FONT></FONT></P>\n" +
                "\t\t\t</TD>\n" +
                "\t\t\t<TD WIDTH=126 BGCOLOR=\"#55a755\" STYLE=\"border: 1px solid #55a755; padding: 0.08in 0in\">\n" +
                "\t\t\t\t<P ALIGN=CENTER><FONT COLOR=\"#ffffff\"><FONT FACE=\"Helvetica, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\"><B>Order\n" +
                "\t\t\t\ttype</B></FONT></FONT></FONT></P>\n" +
                "\t\t\t</TD>\n" +
                "\t\t\t<TD WIDTH=143 BGCOLOR=\"#55a755\" STYLE=\"border: 1px solid #55a755; padding: 0.08in 0in\">\n" +
                "\t\t\t\t<P ALIGN=CENTER><FONT COLOR=\"#ffffff\"><FONT FACE=\"Helvetica, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\"><B>Order\n" +
                "\t\t\t\tvalue</B></FONT></FONT></FONT></P>\n" +
                "\t\t\t</TD>\n" +
                "\t\t\t<TD WIDTH=148 BGCOLOR=\"#55a755\" STYLE=\"border: 1px solid #55a755; padding: 0.08in 0.03in\">\n" +
                "\t\t\t\t<P ALIGN=CENTER><FONT COLOR=\"#ffffff\"><FONT FACE=\"Helvetica, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\"><B>Delivery\n" +
                "\t\t\t\tCharge</B></FONT></FONT></FONT></P>\n" +
                "\t\t\t</TD>\n" +
                "\t\t</TR>\n" +
                "\t\t<TR VALIGN=BOTTOM>\n" +
                "\t\t\t<TD ROWSPAN=4 WIDTH=137 BGCOLOR=\"#ffffff\" STYLE=\"border: 1px solid #55a755; padding: 0.12in 0.06in\">\n" +
                "\t\t\t\t<P ALIGN=CENTER STYLE=\"margin-bottom: 0in\"><FONT FACE=\"Segoe UI, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">Surat</FONT></FONT></P>\n" +
                "\t\t\t\t<P ALIGN=CENTER STYLE=\"margin-bottom: 0in\"><BR>\n" +
                "\t\t\t\t</P>\n" +
                "\t\t\t\t<P ALIGN=CENTER STYLE=\"margin-bottom: 0in\"><BR>\n" +
                "\t\t\t\t</P>\n" +
                "\t\t\t\t<P ALIGN=CENTER STYLE=\"margin-bottom: 0in\"><BR>\n" +
                "\t\t\t\t</P>\n" +
                "\t\t\t\t<P ALIGN=CENTER><BR>\n" +
                "\t\t\t\t</P>\n" +
                "\t\t\t</TD>\n" +
                "\t\t\t<TD ROWSPAN=4 WIDTH=126 BGCOLOR=\"#ffffff\" STYLE=\"border: 1px solid #55a755; padding: 0.12in 0.06in\">\n" +
                "\t\t\t\t<P ALIGN=CENTER STYLE=\"margin-bottom: 0in\"><FONT FACE=\"Segoe UI, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">All\n" +
                "\t\t\t\t(slotted delivery )</FONT></FONT></P>\n" +
                "\t\t\t\t<P ALIGN=CENTER STYLE=\"margin-bottom: 0in\"><BR>\n" +
                "\t\t\t\t</P>\n" +
                "\t\t\t\t<P ALIGN=CENTER STYLE=\"margin-bottom: 0in\"><BR>\n" +
                "\t\t\t\t</P>\n" +
                "\t\t\t\t<P ALIGN=CENTER STYLE=\"margin-bottom: 0in\"><BR>\n" +
                "\t\t\t\t</P>\n" +
                "\t\t\t\t<P ALIGN=CENTER><BR>\n" +
                "\t\t\t\t</P>\n" +
                "\t\t\t</TD>\n" +
                "\t\t\t<TD WIDTH=143 BGCOLOR=\"#ffffff\" STYLE=\"border: 1px solid #55a755; padding: 0.12in 0.06in\">\n" +
                "\t\t\t\t<P ALIGN=CENTER><FONT FACE=\"Segoe UI, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">&lt;\n" +
                "\t\t\t\tRs.100</FONT></FONT></P>\n" +
                "\t\t\t</TD>\n" +
                "\t\t\t<TD WIDTH=148 BGCOLOR=\"#ffffff\" STYLE=\"border: 1px solid #55a755; padding: 0.12in 0.06in\">\n" +
                "\t\t\t\t<P ALIGN=CENTER><FONT FACE=\"Segoe UI, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">Rs.50/-</FONT></FONT></P>\n" +
                "\t\t\t</TD>\n" +
                "\t\t</TR>\n" +
                "\t\t<TR VALIGN=BOTTOM>\n" +
                "\t\t\t<TD WIDTH=143 BGCOLOR=\"#ffffff\" STYLE=\"border: 1px solid #55a755; padding: 0.12in 0.06in\">\n" +
                "\t\t\t\t<P ALIGN=CENTER><FONT FACE=\"Segoe UI, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">Rs.100-150</FONT></FONT></P>\n" +
                "\t\t\t</TD>\n" +
                "\t\t\t<TD WIDTH=148 BGCOLOR=\"#ffffff\" STYLE=\"border: 1px solid #55a755; padding: 0.12in 0.06in\">\n" +
                "\t\t\t\t<P ALIGN=CENTER><FONT FACE=\"Segoe UI, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">Rs.\n" +
                "\t\t\t\t30/-</FONT></FONT></P>\n" +
                "\t\t\t</TD>\n" +
                "\t\t</TR>\n" +
                "\t\t<TR VALIGN=BOTTOM>\n" +
                "\t\t\t<TD WIDTH=143 BGCOLOR=\"#ffffff\" STYLE=\"border: 1px solid #55a755; padding: 0.12in 0.06in\">\n" +
                "\t\t\t\t<P ALIGN=CENTER><FONT FACE=\"Segoe UI, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">Rs.150-200</FONT></FONT></P>\n" +
                "\t\t\t</TD>\n" +
                "\t\t\t<TD WIDTH=148 BGCOLOR=\"#ffffff\" STYLE=\"border: 1px solid #55a755; padding: 0.12in 0.06in\">\n" +
                "\t\t\t\t<P ALIGN=CENTER><FONT FACE=\"Segoe UI, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">Rs.\n" +
                "\t\t\t\t10/-</FONT></FONT></P>\n" +
                "\t\t\t</TD>\n" +
                "\t\t</TR>\n" +
                "\t\t<TR VALIGN=BOTTOM>\n" +
                "\t\t\t<TD WIDTH=143 BGCOLOR=\"#ffffff\" STYLE=\"border: 1px solid #55a755; padding: 0.12in 0.06in\">\n" +
                "\t\t\t\t<P ALIGN=CENTER><FONT FACE=\"Segoe UI, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">Rs.\n" +
                "\t\t\t\t200 and above</FONT></FONT></P>\n" +
                "\t\t\t</TD>\n" +
                "\t\t\t<TD WIDTH=148 BGCOLOR=\"#ffffff\" STYLE=\"border: 1px solid #55a755; padding: 0.12in 0.06in\">\n" +
                "\t\t\t\t<P ALIGN=CENTER><FONT FACE=\"Segoe UI, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">Free</FONT></FONT></P>\n" +
                "\t\t\t</TD>\n" +
                "\t\t</TR>\n" +
                "\t</TABLE>\n" +
                "</CENTER>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3 STYLE=\"font-size: 11pt\"><B>Note:</B></FONT></FONT></FONT><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\"><BR>For\n" +
                "Villezone members delivery charge may be different </FONT></FONT></FONT>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>Do\n" +
                "you deliver in my area?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">You\n" +
                "will be able to check this detail at the time of checkout when you\n" +
                "enter the address. If we are unable to deliver in your area - we will\n" +
                "inform you before checkout.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>Will\n" +
                "someone inform me if my order delivery gets delayed?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">In\n" +
                "case of a delay, our customer support team will keep you updated\n" +
                "about your delivery.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>What\n" +
                "is the minimum order for delivery?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">Minimum\n" +
                "order for delivery is Rs. 100 bill amount</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>Do\n" +
                "you do same day delivery?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">We\n" +
                "do same day delivery provided you place your order before 6:00 pm on\n" +
                "the day you want delivery.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>What\n" +
                "is Same Day Delivery?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">villezone\n" +
                "has now started same day delivery. All you have to do is order before\n" +
                "6:00 pm and we will deliver it to you the same day evening. Any order\n" +
                "placed will be delivered the slot chosen by you. </FONT></FONT></FONT>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>Is\n" +
                "Same Day Delivery applicable to only a few products or all products?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">The\n" +
                "Same day Delivery is applicable to our entire range of products. </FONT></FONT></FONT>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">Order\n" +
                "Related</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>What\n" +
                "are delivery slots?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">Delivery\n" +
                "slots are time slots during which you will receive your order.\n" +
                "villezone currently offers 3 delivery slots each day. These are:</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<TABLE WIDTH=719 CELLPADDING=7 CELLSPACING=0>\n" +
                "\t<COL WIDTH=225>\n" +
                "\t<COL WIDTH=226>\n" +
                "\t<COL WIDTH=225>\n" +
                "\t<TR VALIGN=TOP>\n" +
                "\t\t<TD WIDTH=225 BGCOLOR=\"#70ad47\" STYLE=\"border: 1px solid #ffffff; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in\">\n" +
                "\t\t\t<P ALIGN=CENTER><B><FONT COLOR=\"#00000a\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">CITY</FONT></FONT></FONT></B></P>\n" +
                "\t\t</TD>\n" +
                "\t\t<TD WIDTH=226 BGCOLOR=\"#70ad47\" STYLE=\"border-top: 1px solid #ffffff; border-bottom: none; border-left: 1px solid #ffffff; border-right: 1px solid #ffffff; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in\">\n" +
                "\t\t\t<P ALIGN=CENTER><B><FONT COLOR=\"#00000a\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">ORDER\n" +
                "\t\t\tPLACED BETWEEN</FONT></FONT></FONT></B></P>\n" +
                "\t\t</TD>\n" +
                "\t\t<TD WIDTH=225 BGCOLOR=\"#70ad47\" STYLE=\"border-top: 1px solid #ffffff; border-bottom: none; border-left: 1px solid #ffffff; border-right: 1px solid #ffffff; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in\">\n" +
                "\t\t\t<P ALIGN=CENTER><B><FONT COLOR=\"#00000a\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">ORDER\n" +
                "\t\t\tDELIVERED BETWEEN</FONT></FONT></FONT></B></P>\n" +
                "\t\t</TD>\n" +
                "\t</TR>\n" +
                "\t<TR VALIGN=TOP>\n" +
                "\t\t<TD ROWSPAN=3 WIDTH=225 BGCOLOR=\"#70ad47\" STYLE=\"border-top: 1px solid #ffffff; border-bottom: 1px solid #ffffff; border-left: 1px solid #ffffff; border-right: none; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0in\">\n" +
                "\t\t\t<P ALIGN=CENTER STYLE=\"margin-bottom: 0in\"><BR>\n" +
                "\t\t\t</P>\n" +
                "\t\t\t<P ALIGN=CENTER><B><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">SURAT</FONT></FONT></FONT></B></P>\n" +
                "\t\t</TD>\n" +
                "\t\t<TD WIDTH=226 BGCOLOR=\"#c5e0b3\" STYLE=\"border: 1px solid #ffffff; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in\">\n" +
                "\t\t\t<P ALIGN=CENTER><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">6:00\n" +
                "\t\t\tAM  TO  12:00 PM</FONT></FONT></FONT></P>\n" +
                "\t\t</TD>\n" +
                "\t\t<TD WIDTH=225 BGCOLOR=\"#c5e0b3\" STYLE=\"border: 1px solid #ffffff; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in\">\n" +
                "\t\t\t<P ALIGN=CENTER><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">2:00\n" +
                "\t\t\tPM  TO  5:00 PM</FONT></FONT></FONT></P>\n" +
                "\t\t</TD>\n" +
                "\t</TR>\n" +
                "\t<TR VALIGN=TOP>\n" +
                "\t\t<TD WIDTH=226 STYLE=\"border: 1px solid #ffffff; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in\">\n" +
                "\t\t\t<P ALIGN=CENTER><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">12:00\n" +
                "\t\t\tPM  TO  6:00 PM</FONT></FONT></FONT></P>\n" +
                "\t\t</TD>\n" +
                "\t\t<TD WIDTH=225 STYLE=\"border: 1px solid #ffffff; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in\">\n" +
                "\t\t\t<P ALIGN=CENTER><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">7:00\n" +
                "\t\t\tPM  TO  9:00 PM</FONT></FONT></FONT></P>\n" +
                "\t\t</TD>\n" +
                "\t</TR>\n" +
                "\t<TR VALIGN=TOP>\n" +
                "\t\t<TD WIDTH=226 BGCOLOR=\"#c5e0b3\" STYLE=\"border: 1px solid #ffffff; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in\">\n" +
                "\t\t\t<P ALIGN=CENTER><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">6:00\n" +
                "\t\t\tPM  TO  6:00 AM </FONT></FONT></FONT>\n" +
                "\t\t\t</P>\n" +
                "\t\t</TD>\n" +
                "\t\t<TD WIDTH=225 BGCOLOR=\"#c5e0b3\" STYLE=\"border: 1px solid #ffffff; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in\">\n" +
                "\t\t\t<P ALIGN=CENTER STYLE=\"margin-bottom: 0in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">7:00\n" +
                "\t\t\tAM  TO  10:00 AM </FONT></FONT></FONT>\n" +
                "\t\t\t</P>\n" +
                "\t\t\t<P ALIGN=CENTER><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">(\n" +
                "\t\t\tIN NEXT DAY MORNING )</FONT></FONT></FONT></P>\n" +
                "\t\t</TD>\n" +
                "\t</TR>\n" +
                "</TABLE>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>How\n" +
                "can I check availability of next slot before placing order?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">Once\n" +
                "you log in to your account, you will notice that on the right side of\n" +
                "the website, under &quot;My Basket&quot; the next available slot in\n" +
                "which you can order will be displayed.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>Can\n" +
                "I change my order delivery slot after placing the order?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">Delivery\n" +
                "slot cannot be changed once the order is placed. In case of an urgent\n" +
                "requirement of change of slot please contact our customer support\n" +
                "team and we will try our best to accommodate your request.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>How\n" +
                "do I add or remove products after placing my order?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">Once\n" +
                "you have placed your order you will not be able to make modifications\n" +
                "on the website. Please contact our customer support team for any\n" +
                "modification of order.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>How\n" +
                "do I check the current status of my order?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">We\n" +
                "are inform you by massage about your order status</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>Is\n" +
                "there an order cancellation fee?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">No\n" +
                "there is no cancellation fee.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>What\n" +
                "You Receive Is What You Pay For</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">At\n" +
                "the time of delivery, we advise you to kindly check every item as in\n" +
                "the invoice. Please report any missing item that is invoiced. As a\n" +
                "benefit to our customers, if you are not available at the time of\n" +
                "order delivery or you haven’t checked the list at the time of\n" +
                "delivery we provide a window of 6hrs to report missing items. This is\n" +
                "applicable only for items that are invoiced.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">Customer\n" +
                "Related</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>How\n" +
                "do I contact customer service?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">Our\n" +
                "customer service team is available throughout the week, all seven\n" +
                "days from 10 am to 7 pm. They can be reached at 91 04 91 01 91 or via\n" +
                "email at&nbsp;</FONT></FONT></FONT><A HREF=\"mailto:support@villezone.com\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">support@villezone.com</FONT></FONT></A></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>What\n" +
                "are your timings to contact customer service?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">Our\n" +
                "customer service team is available throughout the week, all seven\n" +
                "days from 10 am to 7 pm.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>How\n" +
                "can I give feedback on the quality of customer service?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">Our\n" +
                "customer support team constantly strives to ensure the best shopping\n" +
                "experience for all our customers. We would love to hear about your\n" +
                "experience with villezone. You got one sms for submit your feedback,\n" +
                "By click on that link you are able to write your review.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>Do\n" +
                "you have offline stores?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">No\n" +
                "we are a purely internet based company and do not have any brick and\n" +
                "mortar stores.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>Where\n" +
                "can I find currently running offers/ promotions?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">There\n" +
                "is a link called &quot;Store Wide Offers&quot; on the top right hand\n" +
                "side of our website. All products with any discount or promotions are\n" +
                "listed under this section.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>What\n" +
                "do I do if an item is defective (broken, leaking, expired)?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">We\n" +
                "have open box delivery system and all information about return and\n" +
                "open box delivery go to return policy page</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>How\n" +
                "will I get my money back in case of a cancellation or return?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">The\n" +
                "money will be credited back to your account in 7-10 working\n" +
                "days.&nbsp;&nbsp;Please contact customer support for any further\n" +
                "assistance regarding this issue.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>I\n" +
                "am a corporate/ business. Can I place orders with villezone.com?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">Yes,\n" +
                "we do bulk supply of products at special prices to institutions such\n" +
                "as schools, restaurants and corporates. Please contact as at\n" +
                "info@villezone.com to know more.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>I'd\n" +
                "like to suggest some products. Who do I contact?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">If\n" +
                "you are unable to find a product or brand that you would like to shop\n" +
                "for, please write to us at support@villezone.com and we will try our\n" +
                "best to make the product available to you.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>How\n" +
                "&amp; where I can give my feedback?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">We\n" +
                "always welcome feedback, both positive and negative from all our\n" +
                "customers. Please feel free to write to us at support@villezone.com,\n" +
                "or call us on 91 04 91 01 91 and we will do our best to incorporate\n" +
                "your suggestions into our system.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>How\n" +
                "can I refer villezone.com to my friends?</FONT></FONT></FONT></P>\n" +
                "<UL>\n" +
                "\t<LI><P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">Login\n" +
                "\tto your villezone account through our website on your desktop or our\n" +
                "\tapp on your mobile.</FONT></FONT></FONT></P>\n" +
                "\t<LI><P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">On\n" +
                "\tWebsite - Click on ‘My Account’ (top right) and you will find\n" +
                "\t‘Refer &amp; Earn’ under ‘My Account’ Menu.</FONT></FONT></FONT></P>\n" +
                "\t<LI><P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">On\n" +
                "\tMobile App – Click on the Sidebar menu (top left) and go to ‘Refer\n" +
                "\t&amp; Earn’.</FONT></FONT></FONT></P>\n" +
                "\t<LI><P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">Use\n" +
                "\tyour unique Referral Code to invite your friends and ask them to\n" +
                "\tsign up using your referral code.</FONT></FONT></FONT></P>\n" +
                "\t<LI><P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">On\n" +
                "\tsuccessful registration and delivery of first order by your friend,\n" +
                "\tyou and your friend earn coupon worth 10% of your friends first\n" +
                "\torder amount ( Maximum coupon amount is Rs. 100 )</FONT></FONT></FONT></P>\n" +
                "</UL>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>I’ve\n" +
                "got a referral code. How do I use it?</FONT></FONT></FONT></P>\n" +
                "<UL>\n" +
                "\t<LI><P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">Go\n" +
                "\tto villezone.com or click the signup link received with the invite\n" +
                "\tand register using your referral code.</FONT></FONT></FONT></P>\n" +
                "\t<LI><P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">Press\n" +
                "\tthe signup button and complete your first purchase.</FONT></FONT></FONT></P>\n" +
                "\t<LI><P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">Once\n" +
                "\tyour order is successfully delivered, villezone will check if all\n" +
                "\tthe required conditions are met and within 24 hours both you and\n" +
                "\tyour friend will receive reward amount by sms and app and web\n" +
                "\tnotification as coupon code</FONT></FONT></FONT></P>\n" +
                "\t<LI><P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">You\n" +
                "\tcan use this coupon for any future purchases with villezone.</FONT></FONT></FONT></P>\n" +
                "</UL>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>How\n" +
                "many friends can I refer?</FONT></FONT></FONT></P>\n" +
                "<UL>\n" +
                "\t<LI><P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">You\n" +
                "\tcan refer up to 20 of your friends to villezone and earn a maximum\n" +
                "\tof Rs.2000 as referral bonus. From the 21st invitation, even if the\n" +
                "\treferee completes the transaction and use the unique referrer code\n" +
                "\twhile signing up, the referral bonus will not be credited.</FONT></FONT></FONT></P>\n" +
                "\t<LI><P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">To\n" +
                "\tensure that users don't get spammed, kindly send invites only to\n" +
                "\tpeople you are acquainted with.</FONT></FONT></FONT></P>\n" +
                "</UL>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">How\n" +
                "Does it Work</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>Where\n" +
                "do the products come from?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">All\n" +
                "orders are processed from Villezone.com and we are purchasing all\n" +
                "product directly from farm and delivered to you by the villezone\n" +
                "team. If you are not happy with any product, we have an </FONT></FONT></FONT><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\"><B>Open\n" +
                "box delivery </B></FONT></FONT></FONT><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">so\n" +
                "you can open your order in front of our delivery boy and if you have\n" +
                "any problem with you can return it at on same spot.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><FONT COLOR=\"#333333\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=3>How\n" +
                "is my order processed?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 0.19in\"><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">As\n" +
                "soon as you place an order, the following actions take place:<BR><BR>1.You\n" +
                "will get a notification through SMS of the confirmed order along with\n" +
                "the expected delivery time.<BR><BR>2.Meanwhile, after the order is\n" +
                "accepted by the company, an executive is deployed by villezone to\n" +
                "pick up the order and deliver the same to you.<BR><BR>4.After the\n" +
                "order is delivered to you successfully, you will receive an SMS\n" +
                "confirming the delivery. You may also receive a call for\n" +
                "feedback.<BR><BR>Throughout the above stages, our Order Fulfilment\n" +
                "Team continuously monitors the process so that you get the desired\n" +
                "product within the time committed to you. In case the order cannot be\n" +
                "processed for any reason whatsoever, the same will be informed to you\n" +
                "at the earliest.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; line-height: 100%\"><BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0.11in\"><B>Note :- </B><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">FOR\n" +
                "MORE QUERY AND INFORMATION PLEASE CONTACT TO OUR CUSTOMER CARE NUMBER\n" +
                "</FONT></FONT></FONT><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\"><B>(\n" +
                "91 04 91 01 91 )</B></FONT></FONT></FONT><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">\n" +
                "AND</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0.11in\"><FONT COLOR=\"#656565\">            \n" +
                "<FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\">WRITE\n" +
                "DOWN US AT </FONT></FONT></FONT><FONT COLOR=\"#656565\"><FONT FACE=\"latoregular, serif\"><FONT SIZE=2 STYLE=\"font-size: 9pt\"><B>support@villezone.com</B></FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0.11in\"><BR><BR>\n" +
                "</P>\n" +
                "</BODY>\n" +
                "</HTML>";

        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadDataWithBaseURL("", data, "text/html", "UTF-8", "");

        return view;
    }
}
