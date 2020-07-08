package Proxy_pattern;

public interface InvocationHandler {
    public abstract Object invoke(Object proxy, Method method, Object[] args);
}
