package cn.aleestar.dto;

/**
 * @Description 返回数据的格式
 * @WebSite https://aleestar.cn
 * @Author aleestar
 * @Date 2021/1/5
 */
public class Response {

    //状态
    private Integer code;
    //消息
    private String message;
    //数据
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Response(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Response ok(String message){
        return new Response(200, message, null);
    }

    public static Response ok(Object data){
        return new Response(200, "操作成功", data);
    }

    public static Response err(String message){
        return new Response(201, message, null);
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
