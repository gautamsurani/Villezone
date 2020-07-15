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
public class AboutUsFragment extends Fragment {

    public AboutUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about_us, container, false);

        WebView webview = view.findViewById(R.id.webView);

        String data = "\n" +
                "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n" +
                "<HTML>\n" +
                "<HEAD>\n" +
                "\t<META HTTP-EQUIV=\"CONTENT-TYPE\" CONTENT=\"text/html; charset=utf-8\">\n" +
                "\t<TITLE></TITLE>\n" +
                "\t<META NAME=\"GENERATOR\" CONTENT=\"LibreOffice 4.1.6.2 (Linux)\">\n" +
                "\t<META NAME=\"AUTHOR\" CONTENT=\"Prakash Nagotha\">\n" +
                "\t<META NAME=\"CREATED\" CONTENT=\"20200712;132200000000000\">\n" +
                "\t<META NAME=\"CHANGEDBY\" CONTENT=\"Prakash Nagotha\">\n" +
                "\t<META NAME=\"CHANGED\" CONTENT=\"20200712;134000000000000\">\n" +
                "\t<META NAME=\"AppVersion\" CONTENT=\"16.0000\">\n" +
                "\t<META NAME=\"DocSecurity\" CONTENT=\"0\">\n" +
                "\t<META NAME=\"HyperlinksChanged\" CONTENT=\"false\">\n" +
                "\t<META NAME=\"LinksUpToDate\" CONTENT=\"false\">\n" +
                "\t<META NAME=\"ScaleCrop\" CONTENT=\"false\">\n" +
                "\t<META NAME=\"ShareDoc\" CONTENT=\"false\">\n" +
                "\t<STYLE TYPE=\"text/css\">\n" +
                "\t<!--\n" +
                "\t\t@page { margin-left: 0.44in; margin-right: 0.46in; margin-top: 0.44in; margin-bottom: 0.44in }\n" +
                "\t\tP { margin-bottom: 0.08in; direction: ltr; widows: 2; orphans: 2 }\n" +
                "\t\tA:link { color: #0000ff; so-language: zxx }\n" +
                "\t-->\n" +
                "\t</STYLE>\n" +
                "</HEAD>\n" +
                "<BODY LANG=\"en-IN\" LINK=\"#0000ff\" DIR=\"LTR\">\n" +
                "<P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 0.21in\"><A NAME=\"what\"></A>\n" +
                "<FONT COLOR=\"#58595b\"><FONT FACE=\"Times New Roman, serif\"><FONT SIZE=5 STYLE=\"font-size: 17pt\">What\n" +
                "is villezone.com</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 0.21in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 0.21in\">\n" +
                "<FONT COLOR=\"#808285\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">villezone.com\n" +
                "is India’s first online food and grocery store who is provide\n" +
                "guaranteed same day delivery.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 0.21in\">\n" +
                "<FONT COLOR=\"#808285\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">Also\n" +
                "with </FONT></FONT></FONT><FONT COLOR=\"#808285\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\"><B>Open\n" +
                "Box Delivery </B></FONT></FONT></FONT><FONT COLOR=\"#808285\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">so\n" +
                "customer haven’t any process after payment for return or refund.\n" +
                "With over 18,000 products and over a 1000 brands in our catalogue you\n" +
                "will find everything you are looking for. Right from fresh Fruits and\n" +
                "Vegetables, Rice and Dals, Spices and Seasonings to Packaged\n" +
                "products, Beverages, Personal care products.<BR>Choose from a wide\n" +
                "range of options in every category, exclusively handpicked to help\n" +
                "you find the best quality available at the lowest prices. Select a\n" +
                "time slot for delivery and your order will be delivered right to your\n" +
                "doorstep, anywhere in Surat. You can pay online using your debit /\n" +
                "credit card or by cash on delivery.<BR>We guarantee on time delivery,\n" +
                "and the best quality!</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 0.21in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 0.21in\">\n" +
                "<FONT COLOR=\"#6d6e71\"><FONT FACE=\"Times New Roman, serif\"><FONT SIZE=4 STYLE=\"font-size: 13pt\">Why\n" +
                "our price is lowest from all market ?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 0.21in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 0.21in\">\n" +
                "<FONT COLOR=\"#808285\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">Villezone.com\n" +
                "is first company in India who provide all your essential product at\n" +
                "your door step with lowest price in market. Because our basic and\n" +
                "main concept is “</FONT></FONT></FONT><FONT COLOR=\"#808285\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\"><B>FARM\n" +
                "TO HOME”. </B></FONT></FONT></FONT><FONT COLOR=\"#808285\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">We\n" +
                "are providing all product directly from farm and that’s why our\n" +
                "price is lowest from all market.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 0.21in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 0.21in\">\n" +
                "<FONT COLOR=\"#808285\"><FONT FACE=\"Arial, serif\"><FONT SIZE=5><B>HAAPY\n" +
                "TO SEE YOU HERE</B></FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 100%\">\n" +
                "<FONT COLOR=\"#000000\">&nbsp;</FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 100%\"><A NAME=\"why\"></A>\n" +
                "<FONT COLOR=\"#58595b\"><FONT FACE=\"Times New Roman, serif\"><FONT SIZE=4>Why\n" +
                "should I use villezone.com?</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 100%\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 100%\">\n" +
                "<FONT COLOR=\"#808285\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">villezone.com\n" +
                "allows you to walk away from the drudgery of grocery shopping and\n" +
                "welcome an easy relaxed way of browsing and shopping for groceries.\n" +
                "Discover new products and shop for all your food and grocery needs\n" +
                "from the comfort of your home or office. No more getting stuck in\n" +
                "traffic jams, paying for parking, standing in long queues and\n" +
                "carrying heavy bags – get everything you need, when you need, right\n" +
                "at your doorstep. Food shopping online is now easy as every product\n" +
                "on your monthly shopping list, is now available online at\n" +
                "villezone.com, India’s best online vegetable &amp; grocery store.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 100%\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P STYLE=\"margin-bottom: 0in; background: #ffffff; line-height: 100%\">\n" +
                "<FONT COLOR=\"#000000\">&nbsp;</FONT></P>\n" +
                "<UL>\n" +
                "\t<LI><P STYLE=\"margin-bottom: 0in; background: #ffffff; border-top: none; border-bottom: 1px solid #dbdbdb; border-left: none; border-right: none; padding-top: 0in; padding-bottom: 0.08in; padding-left: 0in; padding-right: 0in; line-height: 0.21in\"><A NAME=\"how\"></A>\n" +
                "\t<FONT COLOR=\"#808285\"><FONT FACE=\"Times New Roman, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">How\n" +
                "\tdo I order?</FONT></FONT></FONT></P>\n" +
                "\t<UL>\n" +
                "\t\t<OL>\n" +
                "\t\t\t<LI><P STYLE=\"margin-bottom: 0in; background: #ffffff; border-top: none; border-bottom: 1px solid #dbdbdb; border-left: none; border-right: none; padding-top: 0in; padding-bottom: 0.08in; padding-left: 0in; padding-right: 0in; line-height: 0.22in\">\n" +
                "\t\t\t<FONT COLOR=\"#59595b\"><FONT FACE=\"Arial, serif\"><FONT SIZE=4 STYLE=\"font-size: 13pt\">Browse\n" +
                "\t\t\tvillezone.com for products<BR>or use the search feature or\n" +
                "\t\t\tdownload our application from play store</FONT></FONT></FONT></P>\n" +
                "\t\t</OL>\n" +
                "\t</UL>\n" +
                "</UL>\n" +
                "<P STYLE=\"margin-bottom: 0in; background: #ffffff; border-top: none; border-bottom: 1px solid #dbdbdb; border-left: none; border-right: none; padding-top: 0in; padding-bottom: 0.08in; padding-left: 0in; padding-right: 0in; line-height: 100%\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<UL>\n" +
                "\t<UL>\n" +
                "\t\t<OL START=2>\n" +
                "\t\t\t<LI><P STYLE=\"margin-bottom: 0in; background: #ffffff; border-top: none; border-bottom: 1px solid #dbdbdb; border-left: none; border-right: none; padding-top: 0in; padding-bottom: 0.08in; padding-left: 0in; padding-right: 0in; line-height: 0.22in\">\n" +
                "\t\t\t<FONT COLOR=\"#59595b\"><FONT FACE=\"Arial, serif\"><FONT SIZE=4 STYLE=\"font-size: 13pt\">Add\n" +
                "\t\t\titem to your<BR>Shopping Basket</FONT></FONT></FONT></P>\n" +
                "\t\t</OL>\n" +
                "\t</UL>\n" +
                "</UL>\n" +
                "<P STYLE=\"margin-bottom: 0in; background: #ffffff; border-top: none; border-bottom: 1px solid #dbdbdb; border-left: none; border-right: none; padding-top: 0in; padding-bottom: 0.08in; padding-left: 0in; padding-right: 0in; line-height: 100%\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<UL>\n" +
                "\t<UL>\n" +
                "\t\t<OL START=3>\n" +
                "\t\t\t<LI><P STYLE=\"margin-bottom: 0in; background: #ffffff; border-top: none; border-bottom: 1px solid #dbdbdb; border-left: none; border-right: none; padding-top: 0in; padding-bottom: 0.08in; padding-left: 0in; padding-right: 0in; line-height: 0.22in\">\n" +
                "\t\t\t<FONT COLOR=\"#59595b\"><FONT FACE=\"Arial, serif\"><FONT SIZE=4 STYLE=\"font-size: 13pt\">Choose\n" +
                "\t\t\ta convenient delivery<BR>time from our 3 Slots* a day</FONT></FONT></FONT></P>\n" +
                "\t\t</OL>\n" +
                "\t</UL>\n" +
                "</UL>\n" +
                "<P ALIGN=CENTER STYLE=\"margin-left: 0.35in; margin-top: 0.18in; margin-bottom: 0in; background: #ffffff; border-top: 1px solid #e0e0e0; border-bottom: none; border-left: 1px solid #e0e0e0; border-right: 1px solid #e0e0e0; padding: 0in; line-height: 100%\">\n" +
                "<FONT COLOR=\"#000000\"><FONT FACE=\"Arial, serif\"><FONT SIZE=4 STYLE=\"font-size: 13pt\">Time\n" +
                "Slots&nbsp;</FONT></FONT></FONT></P>\n" +
                "<UL>\n" +
                "\t<UL>\n" +
                "\t\t<LI><P ALIGN=CENTER STYLE=\"margin-top: 0.19in; margin-bottom: 0.19in; background: #ffffff; border: 1px solid #e0e0e0; padding: 0in; line-height: 100%\">\n" +
                "\t\t<FONT COLOR=\"#818286\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">7.00\n" +
                "\t\tAM – 10.00 AM</FONT></FONT></FONT></P>\n" +
                "\t\t<LI><P ALIGN=CENTER STYLE=\"margin-top: 0.19in; margin-bottom: 0.19in; background: #ffffff; border: 1px solid #e0e0e0; padding: 0in; line-height: 100%\">\n" +
                "\t\t<FONT COLOR=\"#818286\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">2.00\n" +
                "\t\tPM - 5.00 PM</FONT></FONT></FONT></P>\n" +
                "\t\t<LI><P ALIGN=CENTER STYLE=\"margin-top: 0.19in; margin-bottom: 0.19in; background: #ffffff; border: 1px solid #e0e0e0; padding: 0in; line-height: 100%\">\n" +
                "\t\t<FONT COLOR=\"#818286\"><FONT FACE=\"Arial, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">7.00\n" +
                "\t\tPM – 9.00 PM</FONT></FONT></FONT></P>\n" +
                "\t</UL>\n" +
                "</UL>\n" +
                "<P STYLE=\"margin-bottom: 0in; background: #ffffff; border-top: none; border-bottom: 1px solid #dbdbdb; border-left: none; border-right: none; padding-top: 0in; padding-bottom: 0.08in; padding-left: 0in; padding-right: 0in; line-height: 0.22in\">\n" +
                "<FONT COLOR=\"#59595b\">                       <FONT FACE=\"Arial, serif\"><FONT SIZE=4 STYLE=\"font-size: 13pt\">4)\n" +
                "Select suitable payment<BR>                           option(Cash on\n" +
                "delivery, Debit Card, Credit Card)</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; background: #ffffff; border-top: none; border-bottom: 1px solid #dbdbdb; border-left: none; border-right: none; padding-top: 0in; padding-bottom: 0.08in; padding-left: 0in; padding-right: 0in; line-height: 0.22in\">\n" +
                "<FONT COLOR=\"#59595b\">                       <FONT FACE=\"Arial, serif\"><FONT SIZE=4 STYLE=\"font-size: 13pt\">5)\n" +
                "Your products will be home-delivered<BR>                           as\n" +
                "per your order.</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0in; background: #ffffff; border-top: none; border-bottom: 1px solid #dbdbdb; border-left: none; border-right: none; padding-top: 0in; padding-bottom: 0.08in; padding-left: 0in; padding-right: 0in; line-height: 100%\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<UL>\n" +
                "\t<LI><P STYLE=\"margin-bottom: 0in; background: #ffffff; border-top: none; border-bottom: 1px solid #dbdbdb; border-left: none; border-right: none; padding-top: 0in; padding-bottom: 0.08in; padding-left: 0in; padding-right: 0in; line-height: 0.21in\"><A NAME=\"where\"></A>\n" +
                "\t<FONT COLOR=\"#808285\"><FONT FACE=\"Times New Roman, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">Where\n" +
                "\tdo we operate</FONT></FONT></FONT></P>\n" +
                "</UL>\n" +
                "<P STYLE=\"margin-bottom: 0in; background: #ffffff; border-top: none; border-bottom: 1px solid #dbdbdb; border-left: none; border-right: none; padding-top: 0in; padding-bottom: 0.08in; padding-left: 0in; padding-right: 0in; line-height: 100%\">\n" +
                "<FONT COLOR=\"#000000\"><FONT FACE=\"Trebuchet MS, serif\"><FONT SIZE=4 STYLE=\"font-size: 13pt\">We\n" +
                "currently offer our services in Surat, Gujarat only. But as soon as\n" +
                "possible we are expand our service in all over india</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0.11in\"><BR><BR>\n" +
                "</P>\n" +
                "<UL>\n" +
                "\t<LI><P STYLE=\"margin-bottom: 0in; background: #ffffff; border-top: none; border-bottom: 1px solid #dbdbdb; border-left: none; border-right: none; padding-top: 0in; padding-bottom: 0.08in; padding-left: 0in; padding-right: 0in; line-height: 0.21in\">\n" +
                "\t<FONT COLOR=\"#808285\"><FONT FACE=\"Times New Roman, serif\"><FONT SIZE=2 STYLE=\"font-size: 10pt\">From\n" +
                "\twhere we operating ?</FONT></FONT></FONT></P>\n" +
                "</UL>\n" +
                "<P STYLE=\"margin-bottom: 0in; background: #ffffff; border-top: none; border-bottom: 1px solid #dbdbdb; border-left: none; border-right: none; padding-top: 0in; padding-bottom: 0.08in; padding-left: 0in; padding-right: 0in; line-height: 100%\">\n" +
                "<FONT COLOR=\"#000000\"><FONT FACE=\"Trebuchet MS, serif\"><FONT SIZE=4 STYLE=\"font-size: 13pt\">We\n" +
                "are operating from Nana Varachha, Surat - 395006</FONT></FONT></FONT></P>\n" +
                "<P STYLE=\"margin-bottom: 0.11in\"><BR><BR>\n" +
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
