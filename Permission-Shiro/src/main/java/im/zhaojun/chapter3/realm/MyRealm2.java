package im.zhaojun.chapter3.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

public class MyRealm2 implements Realm {
    @Override
    public String getName() {
        return "myRealm2";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());

        if (!"wang".equals(username)) {
            throw new UnknownAccountException("无效的用户名");
        }

        if (!"123".equals(password)) {
            throw new IncorrectCredentialsException("密码错误");
        }

        return new SimpleAuthenticationInfo(username, password, getName());
    }
}