package com.nguyenvanhailong.quiz_app;

public class QuestionAnswer
{
    public static String question[] ={
            "Thiết bị hub thông thường nằm ở tầng nào của mô hình OSI?",
            "Mạng hình RING sử dụng thiết bị nào?",
            "Địa chỉ nào được Switch sử dụng khi quyết định chuyển tiếp dữ liệu đến các cổng?",
            "Ý nghĩa của địa chỉ MAC là gì?"
    };

    public static String choices[][] = {
            {"A. Tầng 1","B. Tầng 2","C. Tầng 3","D. Tất cả đều sai"},
            {"A. Router","B. Repeater","C. T-Connector","D. Terminator"},
            {"A. Địa chỉ MAC nguồn (Source MAC address)","B. Địa chỉ MAC đích (Destination MAC address)","C. Địa chỉ mạng (Network address)","D. Địa chỉ mạng con (Subnetwork address)"},
            {"A. Định danh một máy tính trên mạng","B. Định danh cho một thiết bị trên mạng","C. Định danh cho một ứng dụng trên mạng","D. Định danh cho một mạng"}
    };

    public static String answers[] = {
            "A. Tầng 1",
            "B. Repeater",
            "B. Địa chỉ MAC đích (Destination MAC address)",
            "B. Định danh cho một thiết bị trên mạng"
    };
}
