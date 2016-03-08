/*
 * Copyright @ 2015 Atlassian Pty Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jitsi.service.neomedia.rtp;

import org.jitsi.impl.neomedia.rtcp.*;

/**
 * A simple interface for handling RTCP NACK packets.
 *
 * @author Boris Grozev
 * @author George Politis
 */
public interface RTCPListener
{
    /**
     * Handles an RTCP NACK packet.
     * @param nackPacket the packet.
     */
    public void nackReceived(NACKPacket nackPacket);

    /**
     * Handles an RTCP FIR packet.
     * @param fir the packet.
     */
    void firReceived(FIRPacket fir);

    /**
     * Handles an RTCP PLI packet.
     * @param pli the packet.
     */
    void pliReceived(PLIPacket pli);
}