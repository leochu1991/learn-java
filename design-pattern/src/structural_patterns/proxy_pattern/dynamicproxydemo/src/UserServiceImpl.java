package structural_patterns.proxy_pattern.dynamicproxydemo.src;

/**
 * 用户service实现类，目标实现类
 */
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("======目标实现类的用户添加方法add()======");
    }
}
