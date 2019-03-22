package serialization;

import org.springframework.core.serializer.support.SerializingConverter;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *  Apple - IdMS Core 4/10/13 10:50 AM
 *
 * @author Dave Knipp knipp@apple.com
 */
public class Application implements Cloneable, Serializable {

    private static final long serialVersionUID = -7154212138528765210L;



    private Long id;

    private String url;
    private String urlWithoutContext;
    private URL parsedUrl;
    private String linkUrl;
    private URL parsedLinkUrl;
    private String recoveryUrl;
    private URL parsedRecoveryUrl;
    private String passwordResetUrl;
    private URL parsedPasswordResetUrl;
    private String unlockAccountUrl;
    private URL parsedUnlockAccountUrl;
    private String password;
    private String name;
    private String description;
    private String version;
    private String loggingTag;
    private String tokenIdentifier;
    private Set<String> authorizedTokenIdentifiers;
    private boolean useCarrierAppIdInDSRequest = false;
    private String encryptionKey; // General purpose encryption key holder.

    private boolean appleConnectEnabled;
    private boolean samlEnabled;
    private boolean samlSingleSignOnEnabled;
    private boolean returnDAWTokenInUrl;

    /* Indicates whether or not this application should require the use of a session in all API calls.  For instance,
     * iForgot must set this to false because it operates primarily as a "sessionless" application since there is not
     * authenticated state.  Since most applications typically operate with authenticated state, the default for this
     * attribute will be set to true. */
    private boolean requiresSession = true;

    private Application carrierApplicationWithEnum;
    private Map<Long, String> applicationReturnUrls = new HashMap<Long, String>();

    public Application() {
    }


    public static Application createWithPassword(Long id, String password) {
        return createWithPassword(id, null, password);
    }

    public static Application createWithPassword(Long id, String name, String password) {
        Application applicationWithEnum = new Application();
        applicationWithEnum.setId(id);
        applicationWithEnum.setName(name);
        applicationWithEnum.setPassword(password);
        return applicationWithEnum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;

    }


    public String getUrl() {
        return url;
    }

    public String getUrlWithoutContext() {
        return this.urlWithoutContext;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public URL parsedUrl() {
        return this.parsedUrl;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public URL parsedLinkUrl() {
        return this.parsedLinkUrl != null ? this.parsedLinkUrl : this.parsedUrl; //default to the primary url if the link url isn't configured
    }

    public String buildFullyQualifiedUrl(String uri) {
        try {
            return new URL(parsedUrl + uri).toString();
        } catch (MalformedURLException mue) {
            return null;
        }
    }

    public String getRecoveryUrl() {
        return recoveryUrl;
    }


    public URL parsedRecoveryUrl() {
        return this.parsedRecoveryUrl;
    }

    public String getPasswordResetUrl() {
        return passwordResetUrl;
    }

    public void setPasswordResetUrl(String passwordResetUrl) {
        this.passwordResetUrl = passwordResetUrl;

    }

    public URL parsedPasswordResetUrl() {
        return this.parsedPasswordResetUrl;
    }

    public String getUnlockAccountUrl() {
        return unlockAccountUrl;
    }

    public void setUnlockAccountUrl(String unlockAccountUrl) {
        this.unlockAccountUrl = unlockAccountUrl;

    }

    public URL parsedUnlockAccountUrl() {
        return parsedUnlockAccountUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLoggingTag() {
        return loggingTag;
    }

    public void setLoggingTag(String loggingTag) {
        this.loggingTag = loggingTag;
    }

    public String getTokenIdentifier() {
        return tokenIdentifier;
    }

    public void setTokenIdentifier(String tokenIdentifier) {
        this.tokenIdentifier = tokenIdentifier;
    }

    public Set<String> getAuthorizedTokenIdentifiers() {
        return authorizedTokenIdentifiers;
    }

    public void setAuthorizedTokenIdentifiers(Set<String> authorizedTokenIdentifiers) {
        this.authorizedTokenIdentifiers = authorizedTokenIdentifiers;
    }



    public boolean isRequiresSession() {
        return requiresSession;
    }

    public void setRequiresSession(boolean requiresSession) {
        this.requiresSession = requiresSession;
    }

    public boolean isUseCarrierAppIdInDSRequest() {
        return useCarrierAppIdInDSRequest;
    }

    public void setUseCarrierAppIdInDSRequest(boolean useCarrierAppIdInDSRequest) {
        this.useCarrierAppIdInDSRequest = useCarrierAppIdInDSRequest;
    }

    public String getEncryptionKey() {
        return encryptionKey;
    }

    public void setEncryptionKey(String encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    public Application getCarrierApplicationWithEnum() {
        return carrierApplicationWithEnum;
    }

    public void setCarrierApplicationWithEnum(Application carrierApplicationWithEnum) {
        this.carrierApplicationWithEnum = carrierApplicationWithEnum;
    }

    public Map<Long, String> getApplicationReturnUrls() {
        return applicationReturnUrls;
    }

    public void setApplicationReturnUrls(Map<Long, String> applicationReturnUrls) {
        this.applicationReturnUrls = applicationReturnUrls;
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Application)) {
            return false;
        }
        Application applicationWithEnum = (Application) obj;
        return this.id != null ? this.id.equals(applicationWithEnum.getId()) : applicationWithEnum.getId() == null;
    }

    public boolean isAppleConnectEnabled() {
        return appleConnectEnabled;
    }

    public void setAppleConnectEnabled(boolean appleConnectEnabled) {
        this.appleConnectEnabled = appleConnectEnabled;
    }

    public boolean isSamlEnabled() {
        return samlEnabled;
    }

    public void setSamlEnabled(boolean samlEnabled) {
        this.samlEnabled = samlEnabled;
    }

    public boolean isSamlSingleSignOnEnabled() {
        return samlSingleSignOnEnabled;
    }

    public void setSamlSingleSignOnEnabled(boolean samlSingleSignOnEnabled) {
        this.samlSingleSignOnEnabled = samlSingleSignOnEnabled;
    }

    public boolean isReturnDAWTokenInUrl() {
        return returnDAWTokenInUrl;
    }

    public void setReturnDAWTokenInUrl(boolean returnDAWTokenInUrl) {
        this.returnDAWTokenInUrl = returnDAWTokenInUrl;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        if (this.name != null) {
            return this.name + " (" + this.id + ")";
        }
        return this.id != null ? this.id.toString() : null;
    }

    public String getSize(SerializingConverter serializingConverter) {
        return "Application1 : {" +

                ", id : " +  ( id != null ? serializingConverter.convert(id).length : 0) +

                ", url : " + ( url != null ? serializingConverter.convert(url).length : 0) +
                ", urlWithoutContext : " + ( urlWithoutContext != null ? serializingConverter.convert(urlWithoutContext).length : 0) +
                ", parsedUrl : " + ( parsedUrl != null ? serializingConverter.convert(parsedUrl).length : 0) +
                ", linkUrl : " + ( linkUrl != null ? serializingConverter.convert(linkUrl).length : 0) +
                ", parsedLinkUrl : " + ( parsedLinkUrl != null ? serializingConverter.convert(parsedLinkUrl).length : 0) +
                ", recoveryUrl : " + ( recoveryUrl != null ? serializingConverter.convert(recoveryUrl).length : 0) +
                ", parsedRecoveryUrl : " + ( parsedRecoveryUrl != null ? serializingConverter.convert(parsedRecoveryUrl).length : 0) +
                ", passwordResetUrl : " + ( passwordResetUrl != null ? serializingConverter.convert(passwordResetUrl).length : 0)  +
                ", parsedPasswordResetUrl : " + ( parsedPasswordResetUrl != null ? serializingConverter.convert(parsedPasswordResetUrl).length : 0) +
                ", unlockAccountUrl : " + ( unlockAccountUrl != null ? serializingConverter.convert(unlockAccountUrl).length : 0) +
                ", parsedUnlockAccountUrl : " + ( parsedUnlockAccountUrl != null ? serializingConverter.convert(parsedUnlockAccountUrl).length : 0) +
                ", password : " + ( password != null ? serializingConverter.convert(password).length : 0)  +
                ", name : " + ( name != null ? serializingConverter.convert(name).length : 0) +
                ", description : " + ( description != null ? serializingConverter.convert(description).length : 0)  +
                ", version : " + ( version != null ? serializingConverter.convert(version).length : 0) +
                ", loggingTag : " + ( loggingTag != null ? serializingConverter.convert(loggingTag).length : 0)  +
                ", tokenIdentifier : " + ( tokenIdentifier != null ? serializingConverter.convert(tokenIdentifier).length : 0) +
                ", authorizedTokenIdentifiers  : " + ( authorizedTokenIdentifiers != null ? serializingConverter.convert(authorizedTokenIdentifiers).length : 0) +
                ", encryptionKey : " + ( encryptionKey != null ? serializingConverter.convert(encryptionKey).length : 0)  +

                ", carrierApplicationWithEnum  : " + ( carrierApplicationWithEnum != null ? serializingConverter.convert(carrierApplicationWithEnum).length : 0) +
                ", applicationReturnUrls  : " + ( applicationReturnUrls != null ? serializingConverter.convert(applicationReturnUrls).length : 0)+
                '}';
    }
}
