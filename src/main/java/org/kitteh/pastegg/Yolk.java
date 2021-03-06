/*
 * * Copyright (C) 2018-2019 Matt Baxter https://kitteh.org
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 * BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 * ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.kitteh.pastegg;

import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import java.nio.charset.Charset;

/**
 * Paste URL shortener. Because paste.gg URLS aren't short enough!
 */
public class Yolk {
    /**
     * Shortens a paste.gg URL.
     *
     * @param url url to shorten
     * @return possibly shortened url
     */
    public static String shorten(String url) {
        try {
            String s = Request.Post("https://yolk.science/paste.php")
                    .bodyForm(Form.form()
                            .add("url", url)
                            .build())
                    .execute()
                    .returnContent().asString(Charset.defaultCharset());
            if (s.startsWith("https://yolk.science")) {
                return s;
            }
        } catch (Exception e) {
            // WHO'S THAT POKEMON?
        }

        return url;
    }
}
