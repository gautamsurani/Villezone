package com.villezone.gautam.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.google.android.material.textview.MaterialTextView;
import com.villezone.gautam.R;

public class FAQFragment extends Fragment {
    public FAQFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_f_a_q, container, false);

        WebView webview = view.findViewById(R.id.webView);

        String data = "\n" +
                "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n" +
                "<HTML>\n" +
                "<HEAD>\n" +
                "\t<META HTTP-EQUIV=\"CONTENT-TYPE\" CONTENT=\"text/html; charset=utf-8\">\n" +
                "\t<TITLE></TITLE>\n" +
                "\t<META NAME=\"GENERATOR\" CONTENT=\"LibreOffice 4.1.6.2 (Linux)\">\n" +
                "\t<META NAME=\"AUTHOR\" CONTENT=\"Prakash Nagotha\">\n" +
                "\t<META NAME=\"CREATED\" CONTENT=\"20200709;53000000000000\">\n" +
                "\t<META NAME=\"CHANGEDBY\" CONTENT=\"Prakash Nagotha\">\n" +
                "\t<META NAME=\"CHANGED\" CONTENT=\"20200709;94300000000000\">\n" +
                "\t<META NAME=\"AppVersion\" CONTENT=\"16.0000\">\n" +
                "\t<META NAME=\"DocSecurity\" CONTENT=\"0\">\n" +
                "\t<META NAME=\"HyperlinksChanged\" CONTENT=\"false\">\n" +
                "\t<META NAME=\"LinksUpToDate\" CONTENT=\"false\">\n" +
                "\t<META NAME=\"ScaleCrop\" CONTENT=\"false\">\n" +
                "\t<META NAME=\"ShareDoc\" CONTENT=\"false\">\n" +
                "\t<STYLE TYPE=\"text/css\">\n" +
                "\t<!--\n" +
                "\t\t@page { margin-left: 0.38in; margin-right: 0.46in; margin-top: 0.38in; margin-bottom: 0.38in }\n" +
                "\t\tP { margin-bottom: 0.08in; direction: ltr; widows: 2; orphans: 2 }\n" +
                "\t\tH1 { margin-top: 0.19in; margin-bottom: 0.19in; direction: ltr; line-height: 100%; widows: 2; orphans: 2; page-break-after: auto }\n" +
                "\t\tH1.western { font-family: \"Times New Roman\", serif }\n" +
                "\t\tH1.cjk { font-family: \"Times New Roman\"; font-size: 24pt; so-language: en-IN }\n" +
                "\t\tH1.ctl { font-family: \"Times New Roman\"; font-size: 24pt; so-language: gu-IN }\n" +
                "\t\tH2 { margin-top: 0.03in; margin-bottom: 0in; direction: ltr; color: #2f5496; page-break-inside: avoid; widows: 2; orphans: 2 }\n" +
                "\t\tH2.western { font-family: \"Calibri Light\", serif; font-size: 13pt; font-weight: normal }\n" +
                "\t\tH2.cjk { font-family: \"Arial\"; font-size: 13pt; font-weight: normal }\n" +
                "\t\tH2.ctl { font-family: ; font-size: 13pt; font-weight: normal }\n" +
                "\t\tA:link { color: #0000ff; so-language: zxx }\n" +
                "\t-->\n" +
                "\t</STYLE>\n" +
                "</HEAD>\n" +
                "<BODY LANG=\"en-IN\" LINK=\"#0000ff\" DIR=\"LTR\">\n" +
                "<P ALIGN=CENTER STYLE=\"margin-top: 0.21in; margin-bottom: 0.05in; background: #ffffff; line-height: 100%\">\n" +
                "<FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=5 STYLE=\"font-size: 16pt\">Returns\n" +
                "Policy</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-top: 0.16in; margin-bottom: 0in; background: #ffffff; line-height: 100%\">\n" +
                "<FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">We\n" +
                "have no Return Policy, because we have open box delivery where you\n" +
                "are eligible for reject order if order is different/quality\n" +
                "issue/damaged product. Read below for know more about open box\n" +
                "delivery</FONT></FONT></FONT></P>\n" +
                "<H1 CLASS=\"western\" ALIGN=CENTER STYLE=\"background: #ffffff\"><FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=5 STYLE=\"font-size: 16pt\"><SPAN STYLE=\"font-weight: normal\">Open\n" +
                "BOX Delivery</SPAN></FONT></FONT></FONT></H1>\n" +
                "<H2 CLASS=\"western\" STYLE=\"margin-top: 0.21in; margin-bottom: 0.05in; background: #ffffff\">\n" +
                "<FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=3><B>FAQ</B></FONT></FONT></FONT></H2>\n" +
                "<P STYLE=\"margin-top: 0.19in; margin-bottom: 0.19in; background: #ffffff; line-height: 100%\">\n" +
                "<FONT FACE=\"Times New Roman, serif\"><FONT SIZE=3><FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\"><SPAN STYLE=\"font-weight: normal\">Q.\n" +
                "What is Open Box Delivery?</SPAN></FONT></FONT></FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-top: 0.19in; margin-bottom: 0.19in; background: #ffffff; line-height: 100%\">\n" +
                "<FONT FACE=\"Times New Roman, serif\"><FONT SIZE=3><FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\"><SPAN STYLE=\"font-weight: normal\">Ans:</SPAN></FONT></FONT></FONT><FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">&nbsp;In\n" +
                "Open Box Delivery, our delivery boy will open the package in front of\n" +
                "you at the time of delivery. Both outside as well as the brand\n" +
                "packing is opened and shown to you. This ensures that you only\n" +
                "receive what you ordered.</FONT></FONT></FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-top: 0.19in; margin-bottom: 0.19in; background: #ffffff; line-height: 100%\">\n" +
                "<FONT FACE=\"Times New Roman, serif\"><FONT SIZE=3><FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\"><SPAN STYLE=\"font-weight: normal\">Q.\n" +
                "Is this Service available everywhere?</SPAN></FONT></FONT></FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-top: 0.19in; margin-bottom: 0.19in; background: #ffffff; line-height: 100%\">\n" +
                "<FONT FACE=\"Times New Roman, serif\"><FONT SIZE=3><FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\"><SPAN STYLE=\"font-weight: normal\">Ans:</SPAN></FONT></FONT></FONT><FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">&nbsp;Yes,\n" +
                "this service is available for everywhere</FONT></FONT></FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-top: 0.19in; margin-bottom: 0.19in; background: #ffffff; line-height: 100%\">\n" +
                "<FONT FACE=\"Times New Roman, serif\"><FONT SIZE=3><FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\"><SPAN STYLE=\"font-weight: normal\">Q.\n" +
                "How do I avail of this service?</SPAN></FONT></FONT></FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-top: 0.19in; margin-bottom: 0.19in; background: #ffffff; line-height: 100%\">\n" +
                "<FONT FACE=\"Times New Roman, serif\"><FONT SIZE=3><FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\"><SPAN STYLE=\"font-weight: normal\">Ans:</SPAN></FONT></FONT></FONT><FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">&nbsp;This\n" +
                "is automatic system if you order anything from Villezone.com than you\n" +
                "got all delivery as OBD.</FONT></FONT></FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-top: 0.19in; margin-bottom: 0.19in; background: #ffffff; line-height: 100%\">\n" +
                "<FONT FACE=\"Times New Roman, serif\"><FONT SIZE=3><FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\"><SPAN STYLE=\"font-weight: normal\">Q.\n" +
                "Is this Service Free?</SPAN></FONT></FONT></FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-top: 0.19in; margin-bottom: 0.19in; background: #ffffff; line-height: 100%\">\n" +
                "<FONT FACE=\"Times New Roman, serif\"><FONT SIZE=3><FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\"><SPAN STYLE=\"font-weight: normal\">Ans:</SPAN></FONT></FONT></FONT><FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">&nbsp;Open\n" +
                "Box Delivery is a Free service.</FONT></FONT></FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-top: 0.19in; margin-bottom: 0.19in; background: #ffffff; line-height: 100%\">\n" +
                "<FONT FACE=\"Times New Roman, serif\"><FONT SIZE=3><FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\"><SPAN STYLE=\"font-weight: normal\">Q.\n" +
                "In case of COD, when should I make payment? Before or After Open Box\n" +
                "Delivery?</SPAN></FONT></FONT></FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-top: 0.19in; margin-bottom: 0.19in; background: #ffffff; line-height: 100%\">\n" +
                "<FONT FACE=\"Times New Roman, serif\"><FONT SIZE=3><FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\"><SPAN STYLE=\"font-weight: normal\">Ans:</SPAN></FONT></FONT></FONT><FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">&nbsp;You\n" +
                "should always complete the payment before availing of Open box\n" +
                "Delivery. In case you find the product is missing, damaged or\n" +
                "completely different from what you ordered you can return the product\n" +
                "immediately and get a refund on it.</FONT></FONT></FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-top: 0.19in; margin-bottom: 0.19in; background: #ffffff; line-height: 100%\">\n" +
                "<FONT FACE=\"Times New Roman, serif\"><FONT SIZE=3><FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\"><SPAN STYLE=\"font-weight: normal\">Q.\n" +
                "What will happen if the product is found to be missing/damaged/not\n" +
                "what I ordered at the time of the delivery?</SPAN></FONT></FONT></FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-top: 0.19in; margin-bottom: 0.19in; background: #ffffff; line-height: 100%\">\n" +
                "<FONT FACE=\"Times New Roman, serif\"><FONT SIZE=3><FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\"><SPAN STYLE=\"font-weight: normal\">Ans:</SPAN></FONT></FONT></FONT><FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">&nbsp;In\n" +
                "case you find the product to be missing, damaged or completely\n" +
                "different from what you ordered, please ask our delivery boy to take\n" +
                "it back immediately. In case of COD orders, you'll get your refund\n" +
                "immediately from the delivery boy. In case of prepaid orders, you'll\n" +
                "get a refund credited to your account according to the company’s\n" +
                "returns policy.</FONT></FONT></FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-top: 0.19in; margin-bottom: 0.19in; background: #ffffff; line-height: 100%\">\n" +
                "<FONT FACE=\"Times New Roman, serif\"><FONT SIZE=3><FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\"><SPAN STYLE=\"font-weight: normal\">Q.\n" +
                "Can I get a replacement instead of refund?</SPAN></FONT></FONT></FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-top: 0.19in; margin-bottom: 0.19in; background: #ffffff; line-height: 100%\">\n" +
                "<FONT FACE=\"Times New Roman, serif\"><FONT SIZE=3><FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">Ans:\n" +
                "Yes, you got replacement but next day not for right now.</FONT></FONT></FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-top: 0.19in; margin-bottom: 0.19in; background: #ffffff; line-height: 100%\">\n" +
                "<FONT FACE=\"Times New Roman, serif\"><FONT SIZE=3><FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\"><SPAN STYLE=\"font-weight: normal\">Q.\n" +
                "Are all the payment modes available with OBD?</SPAN></FONT></FONT></FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-top: 0.19in; margin-bottom: 0.19in; background: #ffffff; line-height: 100%\">\n" +
                "<FONT FACE=\"Times New Roman, serif\"><FONT SIZE=3><FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">Ans:\n" +
                "All the other payment modes except Card on Delivery is available\n" +
                "along with Open Box Delivery orders.</FONT></FONT></FONT></FONT></FONT></P>\n" +
                "<H2 CLASS=\"western\" STYLE=\"margin-top: 0.21in; margin-bottom: 0.05in; background: #ffffff\">\n" +
                "<FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=3><B>Please\n" +
                "Note:</B></FONT></FONT></FONT></H2>\n" +
                "<UL>\n" +
                "\t<LI><P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 0.22in\">\n" +
                "\t<FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">In\n" +
                "\tOpen Box Delivery, our Delivery boy will open the package in front\n" +
                "\tof you at the time of delivery. Both outside as well as the brand\n" +
                "\tpacking is opened and shown to you. This ensures that you only\n" +
                "\treceive what you ordered</FONT></FONT></FONT></P>\n" +
                "\t<LI><P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 0.22in\">\n" +
                "\t<FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">In\n" +
                "\tcase you find the product to be missing, damaged or completely\n" +
                "\tdifferent from what you ordered please ask the Wish master to take\n" +
                "\tit back immediately. In case of COD you'll get your refund\n" +
                "\timmediately from the Wish master. In case of prepaid orders, you'll\n" +
                "\tget a refund credited to your account according to seller's return\n" +
                "\tpolicy</FONT></FONT></FONT></P>\n" +
                "\t<LI><P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 0.22in\">\n" +
                "\t<FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">Return\n" +
                "\trequests for Missing, Damaged or Mis-shipment will not be accepted\n" +
                "\tonce Open Box Delivery is successfully completed</FONT></FONT></FONT></P>\n" +
                "\t<LI><P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 0.22in\">\n" +
                "\t<FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">In\n" +
                "\tcase you find the device to be defective upon turning it on, you may\n" +
                "\tcontact Villezone.com for replacement/refund as per the returns\n" +
                "\tpolicy</FONT></FONT></FONT></P>\n" +
                "\t<LI><P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 0.22in\">\n" +
                "\t<FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">Card\n" +
                "\ton Delivery is not acceptable for Open Box Delivery</FONT></FONT></FONT></P>\n" +
                "\t<LI><P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 0.22in\">\n" +
                "\t<FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">Customer\n" +
                "\tshould complete payment before opening the box (for COD orders)</FONT></FONT></FONT></P>\n" +
                "</UL>\n" +
                "<H2 CLASS=\"western\" STYLE=\"margin-top: 0.21in; margin-bottom: 0.05in; background: #ffffff\">\n" +
                "<FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=3><B>By\n" +
                "opting in to Open Box Delivery you are agreeing to the following\n" +
                "Terms &amp; Conditions:</B></FONT></FONT></FONT></H2>\n" +
                "<UL>\n" +
                "\t<LI><P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 0.22in\">\n" +
                "\t<FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">You\n" +
                "\tunderstand that for open box delivery, you are required to take the\n" +
                "\tdelivery of product in person after producing a valid identity card.\n" +
                "\tProduction of valid identity card is optional only if there are\n" +
                "\tother modes of delivery available at Your pin code other than open\n" +
                "\tbox delivery.</FONT></FONT></FONT></P>\n" +
                "\t<LI><P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 0.22in\">\n" +
                "\t<FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">In\n" +
                "\tcase You choose cash on delivery mode of payment at the time of\n" +
                "\torder, you understand and agree that the payment has to be made in\n" +
                "\tfull before the product can be opened to complete the open box\n" +
                "\tdelivery.</FONT></FONT></FONT></P>\n" +
                "\t<LI><P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 0.22in\">\n" +
                "\t<FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">You\n" +
                "\tagree and understand that only the delivery boy is entitled to open\n" +
                "\tproduct package and deliver the product to You for Your inspection</FONT></FONT></FONT></P>\n" +
                "\t<LI><P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 0.22in\">\n" +
                "\t<FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">You\n" +
                "\tagree to inspect the product in the presence of the Wish master and\n" +
                "\tconfirm on the product by signing on the mobile/paper delivery\n" +
                "\tsheet. You understand that inspection means checking the physical\n" +
                "\tappearance &amp; components of the product, if any, and does not\n" +
                "\tinclude testing the functioning of the product</FONT></FONT></FONT></P>\n" +
                "\t<LI><P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 0.22in\">\n" +
                "\t<FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">You\n" +
                "\tunderstand that in case the product purchased is not the same as the\n" +
                "\tproduct delivered, the delivery will be considered as 'failed' and\n" +
                "\tthe refund of the product price paid will be refunded as per\n" +
                "\tpolicies of the seller of the product. In case of cash paid on\n" +
                "\tdelivery, the refund will be made to You immediately by the Wish\n" +
                "\tmaster.</FONT></FONT></FONT></P>\n" +
                "\t<LI><P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 0.22in\">\n" +
                "\t<FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">You\n" +
                "\tagree and understand that all other policies of the seller/Website\n" +
                "\twill be suitably applicable to You and the transaction completed on\n" +
                "\tthe Website and You agree to abide by and adhere to the same.</FONT></FONT></FONT></P>\n" +
                "\t<LI><P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 0.22in\">\n" +
                "\t<FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">You\n" +
                "\tagree and understand that these terms and conditions are part and\n" +
                "\tparcel of the Villezone.com 'Terms of Use' and shall be read in\n" +
                "\tconjunction with the same.</FONT></FONT></FONT></P>\n" +
                "</UL>\n" +
                "<P STYLE=\"margin-top: 0.16in; margin-bottom: 0in; background: #ffffff; line-height: 100%\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-top: 0.16in; margin-bottom: 0in; background: #ffffff; line-height: 100%\">\n" +
                "<FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">Returns\n" +
                "is a scheme provided by Villezone.com directly under this policy in\n" +
                "terms of which the option of exchange, replacement and/ or refund is\n" +
                "offered by the company to you. All products listed under a particular\n" +
                "category may not have the same returns policy. For all products, the\n" +
                "returns/replacement policy provided on the product page shall prevail\n" +
                "over the general returns policy. Do refer the respective item's\n" +
                "applicable return/replacement policy on the product page for any\n" +
                "exceptions to this returns policy and the table below</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-top: 0.16in; margin-bottom: 0in; background: #ffffff; line-height: 100%\">\n" +
                "<FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">Do\n" +
                "read all sections carefully to understand the conditions and cases\n" +
                "under which returns will be accepted.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-top: 0.16in; margin-bottom: 0in; background: #ffffff; line-height: 100%\">\n" +
                "<FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">Part\n" +
                "1 – Category, Return Window and Actions possible</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-top: 0.16in; margin-bottom: 0in; background: #ffffff; line-height: 100%\">\n" +
                "<FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">\t</FONT></FONT></FONT></P>\n" +
                "<TABLE WIDTH=493 CELLPADDING=7 CELLSPACING=0>\n" +
                "\t<COL WIDTH=62>\n" +
                "\t<COL WIDTH=402>\n" +
                "\t<TR>\n" +
                "\t\t<TD WIDTH=62 HEIGHT=17 STYLE=\"border: 1.50pt solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in\">\n" +
                "\t\t\t<P ALIGN=CENTER STYLE=\"margin-top: 0.16in\"><FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">Category</FONT></FONT></FONT></P>\n" +
                "\t\t</TD>\n" +
                "\t\t<TD WIDTH=402 STYLE=\"border: 1.50pt solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in\">\n" +
                "\t\t\t<P ALIGN=CENTER STYLE=\"margin-top: 0.16in\"><FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">Returns\n" +
                "\t\t\tWindow, Actions Possible and Conditions (if any)</FONT></FONT></FONT></P>\n" +
                "\t\t</TD>\n" +
                "\t</TR>\n" +
                "\t<TR>\n" +
                "\t\t<TD WIDTH=62 HEIGHT=18 STYLE=\"border-top: 1.50pt solid #00000a; border-bottom: 1px solid #00000a; border-left: 1px solid #00000a; border-right: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in\">\n" +
                "\t\t\t<P ALIGN=CENTER STYLE=\"margin-top: 0.16in\"><FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">Vegetable</FONT></FONT></FONT></P>\n" +
                "\t\t</TD>\n" +
                "\t\t<TD WIDTH=402 STYLE=\"border-top: 1.50pt solid #00000a; border-bottom: 1px solid #00000a; border-left: 1px solid #00000a; border-right: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in\">\n" +
                "\t\t\t<P ALIGN=CENTER STYLE=\"margin-top: 0.16in\"><FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">No\n" +
                "\t\t\tReturn Because we are Providing Open box delivery</FONT></FONT></FONT></P>\n" +
                "\t\t</TD>\n" +
                "\t</TR>\n" +
                "\t<TR>\n" +
                "\t\t<TD WIDTH=62 HEIGHT=18 STYLE=\"border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in\">\n" +
                "\t\t\t<P ALIGN=CENTER STYLE=\"margin-top: 0.16in\"><FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">Grocery</FONT></FONT></FONT></P>\n" +
                "\t\t</TD>\n" +
                "\t\t<TD WIDTH=402 STYLE=\"border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in\">\n" +
                "\t\t\t<P ALIGN=CENTER STYLE=\"margin-top: 0.16in\"><FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">No\n" +
                "\t\t\tReturn Because we are Providing Open box delivery</FONT></FONT></FONT></P>\n" +
                "\t\t</TD>\n" +
                "\t</TR>\n" +
                "</TABLE>\n" +
                "<P STYLE=\"margin-top: 0.16in; margin-bottom: 0in; background: #ffffff; line-height: 100%\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-top: 0.16in; margin-bottom: 0in; background: #ffffff; line-height: 100%\">\n" +
                "<FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">The\n" +
                "field executive will refuse to accept the return if any of the above\n" +
                "conditions are not met.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-top: 0.16in; margin-bottom: 0in; background: #ffffff; line-height: 100%\">\n" +
                "<FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">For\n" +
                "any products for which a refund is to be given, the refund will be\n" +
                "processed once the returned product has been received by the seller.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-top: 0.16in; margin-bottom: 0in; background: #ffffff; line-height: 100%\">\n" +
                "<FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">Part\n" +
                "3 - General Rules for a successful Return</FONT></FONT></FONT></P>\n" +
                "<OL>\n" +
                "\t<LI><P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 0.22in\">\n" +
                "\t<FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">In\n" +
                "\tcertain cases where the seller is unable to process a replacement\n" +
                "\tfor any reason whatsoever, a refund will be given.</FONT></FONT></FONT></P>\n" +
                "\t<LI><P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 0.22in\">\n" +
                "\t<FONT COLOR=\"#212121\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">During\n" +
                "\topen box deliveries, while accepting your order, if you received a\n" +
                "\tdifferent or a damaged product, you will be given a refund (on the\n" +
                "\tspot refunds for cash-on-delivery orders). Once you have accepted an\n" +
                "\topen box delivery, no return request will be processed, except for\n" +
                "\tmanufacturing defects. In such cases, this category-specific\n" +
                "\treplacement/return general conditions will be applicable</FONT></FONT></FONT></P>\n" +
                "</OL>\n" +
                "<P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 0.22in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 0.22in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 0.22in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0.11in\"><BR><BR>\n" +
                "</P>\n" +
                "</BODY>\n" +
                "</HTML>";

        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadDataWithBaseURL("", data, "text/html", "UTF-8", "");

        return view;
    }
}
