/*
 * Copyright 2009 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty.buffer;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests duplicated channel buffers
 *
 * @author <a href="http://www.jboss.org/netty/">The Netty Project</a>
 * @author <a href="http://gleamynode.net/">Trustin Lee</a>
 */
public class DuplicateChannelBufferTest extends AbstractChannelBufferTest {

    private ChannelBuffer buffer;

    @Override
    protected ChannelBuffer newBuffer(int length) {
        buffer = new DuplicatedChannelBuffer(ChannelBuffers.buffer(length));
        assertEquals(0, buffer.writerIndex());
        return buffer;
    }

    @Override
    protected ChannelBuffer[] components() {
        return new ChannelBuffer[] { buffer };
    }

    @Test(expected = NullPointerException.class)
    public void shouldNotAllowNullInConstructor() {
        new DuplicatedChannelBuffer(null);
    }
}