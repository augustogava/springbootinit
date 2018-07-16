package br.com.gava.cache.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.gava.cache.IEditorCache;

@Component
public class EditorCache implements IEditorCache {

	private static final Logger LOGGER = LoggerFactory.getLogger(IEditorCache.class);
	
	@Override
    public void init() {
		LOGGER.debug( "init Editor Cache" );
    }
}