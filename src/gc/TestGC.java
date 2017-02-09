package gc;

import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

public class TestGC {

    private static void init() throws MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {
        MBeanServer mbs = null;
        mbs = ManagementFactory.getPlatformMBeanServer();
        GCTestAgent agent = new GCTestAgent();
        ObjectName agentName;
        agentName = new ObjectName("PVTests:name=GCTestAgent");
        mbs.registerMBean(agent, agentName);
    }

    public static void main(String[] args) throws Exception {
        init();
        for (;;) {
            Thread.sleep(1000);
        }
    }
}
