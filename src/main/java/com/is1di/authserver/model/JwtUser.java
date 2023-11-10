package com.is1di.authserver.model;

import lombok.Data;
import org.springframework.security.oauth2.core.ClaimAccessor;
import org.springframework.util.Assert;

import java.net.URI;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Data
public class JwtUser implements ClaimAccessor {
    private final Map<String, Object> claims;

    public JwtUser(Map<String, Object> claims) {
        Assert.notEmpty(claims, "claims cannot be empty");
        this.claims = Collections.unmodifiableMap(new LinkedHashMap<>(claims));
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Map<String, Object> getClaims() {
        return this.claims;
    }

    public static final class Builder {

        private final Map<String, Object> claims = new LinkedHashMap<>();

        private Builder() {
        }

        public Builder claim(String name, Object value) {
            this.claims.put(name, value);
            return this;
        }

        public Builder sub(String sub) {
            return this.claim(ClaimNames.SUB, sub);
        }

        public Builder fullName(String fullName) {
            return this.claim(ClaimNames.FULL_NAME, fullName);
        }

        public Builder picture(URI picture) {
            return this.claim(ClaimNames.PICTURE, picture);
        }

        public Builder email(String email) {
            return this.claim(ClaimNames.EMAIL, email);
        }

        public Builder phoneNumber(String phoneNumber) {
            return this.claim(ClaimNames.PHONE_NUMBER, phoneNumber);
        }

        public Builder group(String group) {
            return this.claim(ClaimNames.GROUP, group);
        }

        public Builder direction(String directions) {
            return this.claim(ClaimNames.DIRECTION, directions);
        }

        public Builder imgUrl(String imgUrl) {
            return this.claim(ClaimNames.PICTURE,imgUrl);
        }

        public Builder authorities(Set<String> authorities) {
            return this.claim(ClaimNames.AUTHORITY, authorities);
        }

        public Builder department(String department) {
            return this.claim(ClaimNames.DEPARTMENT, department);
        }

        public Builder position(String position){
            return this.claim(ClaimNames.POSITION,position);
        }

        public JwtUser build() {
            return new JwtUser(this.claims);
        }
    }
}
